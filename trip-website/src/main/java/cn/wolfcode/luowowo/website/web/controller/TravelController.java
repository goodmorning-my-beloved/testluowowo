package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.query.TravelQuery;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.article.service.IStrategyDetailService;
import cn.wolfcode.luowowo.article.service.ITravelContentService;
import cn.wolfcode.luowowo.article.service.ITravelService;
import cn.wolfcode.luowowo.cache.service.ITravelStatisVOredisService;
import cn.wolfcode.luowowo.comment.domain.TravelComment;
import cn.wolfcode.luowowo.comment.service.ITravelCommentService;
import cn.wolfcode.luowowo.common.exception.LogicException;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import cn.wolfcode.luowowo.website.web.util.UMEditorUploader;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/travel")
public class TravelController {

    @Reference
    private ITravelService travelService;
    @Reference
    private IDestinationService destinationService;
    @Reference
    private IStrategyDetailService strategyDetailService;
    @Reference
    private ITravelContentService travelContentService;
    @Reference
    private ITravelCommentService travelCommentService;
    @Reference
    private ITravelStatisVOredisService travelStatisVOredisService;

    @RequestMapping("")
    public String list(Model model, @ModelAttribute("qo")TravelQuery qo,@UserParam UserInfo user){
       PageInfo pageInfo= travelService.queryForList(qo);
       model.addAttribute("user",user);
       model.addAttribute("pageInfo",pageInfo);
        return "travel/list";
    }

    @RequestMapping("input")
    public String input(Model model,Long id,@UserParam UserInfo user){
        //如果没登录或者登陆用户与作者不一致
        if(user==null||
                (user!=null&&id!=null&&
                        travelService.getAuthorById(id).getId()!=null&&
                        user.getId()!= travelService.getAuthorById(id).getId())){
            return "redirect:/login.html";
        }
        if(id!=null){
            Travel travel = travelService.selectById(id);
            travel.setTravelContent(travelContentService.getById(id));
            model.addAttribute("tv",travel);
        }
        model.addAttribute("dests", destinationService.list());
        return "travel/input";
    }

    //上传图片
    @Value("${file.path}")
    private String filePath;
    @RequestMapping("/contentImage")
    @ResponseBody
    public String uploadUEImage(MultipartFile upfile, HttpServletRequest request) throws Exception{
        UMEditorUploader up = new UMEditorUploader(request);
        String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
        up.setAllowFiles(fileType);
        up.setMaxSize(10000); //单位KB
        up.upload(upfile, filePath);

        String callback = request.getParameter("callback");
        String result = "{\"name\":\""+ up.getFileName() +"\", \"originalName\": \""+ up.getOriginalName() +"\", \"size\": "+ up.getSize()
                +", \"state\": \""+ up.getState() +"\", \"type\": \""+ up.getType() +"\", \"url\": \""+ up.getUrl() +"\"}";
        result = result.replaceAll( "\\\\", "\\\\" );
        if(callback == null ){
            return result ;
        }else{
            return "<script>"+ callback +"(" + result + ")</script>";
        }
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(Travel travel, @UserParam UserInfo user){
        //如果没登录或者登陆失效
        if(user==null){
            throw new LogicException("您未登录或者登录失效!");
        }
        travel.setAuthor(user);
        Long id=travelService.saveOrUpdate(travel);
        return AjaxResult.SUCCESS.addData(id);
    }

    @RequestMapping("detail")
    public String list(Model model, Long id,@UserParam UserInfo user){
        Travel detail = travelService.selectById(id);
        detail.setTravelContent(travelContentService.getById(detail.getId()));
        List<Destination> toasts = destinationService.getToasts(detail.getDest().getId());
        toasts.remove(toasts.size() - 1);
        //游记作者,跟登录用户
        model.addAttribute("author",travelService.getAuthorById(id));
        model.addAttribute("user",user);
        model.addAttribute("sds",
                strategyDetailService.queryDetailsTop3ByDestId(detail.getDest().getId()));
        model.addAttribute("ts",travelService.
                queryTravelTop3ByDestId(detail.getDest().getId()));
        model.addAttribute("detail",detail);
        model.addAttribute("toasts",toasts);
        model.addAttribute("detail",detail);
        //查评论
        model.addAttribute("list",travelCommentService.selectCommentByTravelId(id));
        //阅读数加1
        travelStatisVOredisService.viewnumIncrease(id);
        model.addAttribute("vo",travelStatisVOredisService.selectById(id));
        //是否收藏
        if (user != null) {
            model.addAttribute("isFavor", travelStatisVOredisService.selectISFavorByUId(detail.getId(), user.getId()));
        }
        return "travel/detail";
    }

    @RequestMapping("/commentAdd")
    public String commentAdd(Model model, TravelComment comment,@UserParam UserInfo userInfo){
        // 判断有没登录
        if (userInfo==null){
            model.addAttribute("userId",-1);
            return "travel/commentTpl";
        }
        comment=travelCommentService.saveOrUpdate(comment,userInfo);
        //floor第几楼的处理,无非就是当前游记有多少个评论
        model.addAttribute("floor",travelCommentService.selectCountByTravelid(comment.getTravelId()));
        model.addAttribute("c",comment);
        //评论游记的时候,在redis中保存这个用户点评数加一
        travelStatisVOredisService.userTravelCommentAddNum(userInfo.getId());
        return "travel/commentTpl";
    }

    @RequestMapping("/travelThumbup")
    @ResponseBody
    public Object travelThumbup(Long sid, @UserParam UserInfo userInfo) {
        AjaxResult ajaxResult = new AjaxResult();
        if (userInfo == null) {
            ajaxResult = new AjaxResult(false, "请先登录");
            ajaxResult.setCode(102);
            return ajaxResult;
        }
        boolean b = travelStatisVOredisService.Thumbup(sid, userInfo.getId());
        ajaxResult.setData(travelStatisVOredisService.selecttravelStatisVOById(sid));
        ajaxResult.setSuccess(b);

        return ajaxResult;
    }

    @RequestMapping("/favor")
    @ResponseBody
    public Object favor(Long sid, @UserParam UserInfo userInfo) {//攻略id
        AjaxResult ajaxResult = new AjaxResult();
        if (userInfo == null) {
            ajaxResult = new AjaxResult(false, "请先登录");
            ajaxResult.setCode(102);
            return ajaxResult;
        }
        boolean b = travelStatisVOredisService.favor(sid, userInfo);

        ajaxResult.setSuccess(b);

        return ajaxResult;
    }




}
