package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.StrategyCommend;
import cn.wolfcode.luowowo.article.domain.StrategyContent;
import cn.wolfcode.luowowo.article.domain.StrategyDetail;
import cn.wolfcode.luowowo.article.query.StrategyDetailQuery;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.article.service.IStrategyCommendService;
import cn.wolfcode.luowowo.article.service.IStrategyDetailService;
import cn.wolfcode.luowowo.article.service.IStrategyTagService;
import cn.wolfcode.luowowo.cache.domain.StrategyStatisVO;
import cn.wolfcode.luowowo.cache.service.IStrategyStatisVOredisService;
import cn.wolfcode.luowowo.comment.domain.StrategyComment;
import cn.wolfcode.luowowo.comment.query.StrategyCommentQuery;
import cn.wolfcode.luowowo.comment.service.IStrategyCommentService;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.search.query.SearchQueryObject;
import cn.wolfcode.luowowo.search.service.IStrategySearchService;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("strategy")
public class StrategyController {

    @Reference
    private IStrategyDetailService strategyDetailService;
    @Reference
    private IDestinationService destinationService;
    @Reference
    private IStrategyTagService strategyTagService;
    @Reference
    private IStrategyCommentService strategyCommentService;
    @Reference
    private IStrategyStatisVOredisService strategyStatisVOredisService;
    @Reference
    private IStrategyCommendService strategyCommendService;
    @Reference
    private IStrategySearchService strategySearchService;

    @RequestMapping("")
    public String index(Model model) {
        //hotCds 热门攻略排序
        //unabroadCds 国内热门攻略排序
        //abroadCds 国外热门攻略排序
        List<StrategyStatisVO> list = strategyStatisVOredisService.queryCommendList();
        List<StrategyStatisVO> unabroadCds = new ArrayList<>();
        List<StrategyStatisVO> abroadCds = new ArrayList<>();
        for (StrategyStatisVO vo : list) {
            if (vo.isIsabroad()) {
                //国外
                if (abroadCds.size() < 10) {
                    abroadCds.add(vo);
                }
            } else {
                if (unabroadCds.size() < 10) {
                    unabroadCds.add(vo);

                }
            }
        }
        model.addAttribute("hotCds", strategyStatisVOredisService.hotCDsTop(9));
        model.addAttribute("unabroadCds", unabroadCds);
        model.addAttribute("abroadCds", abroadCds);
        model.addAttribute("commends", strategyCommendService.queryTop(5));
        //themeCDs
        List<Map<String,Object>> themeCds=strategySearchService.queryThemeTop10();
        model.addAttribute("themeCds",themeCds);
        //themes
        model.addAttribute("themes",strategySearchService.queryConditionThemeGroup());
        //abroads
        model.addAttribute("abroads",strategySearchService.queryConditionAbroadsGroup());
        //chinas
        model.addAttribute("chinas",strategySearchService.queryConditionProvincesGroup());
        return "strategy/index";
    }

    @RequestMapping("/searchPage")
    public String searchPage(Model model,@ModelAttribute("qo")SearchQueryObject qo){
        model.addAttribute("page",strategySearchService.query(qo));
        return "strategy/searchPageTpl";
    }

    @RequestMapping("/detail")
    public Object get(Model model, Long id, @UserParam UserInfo userInfo) {
        StrategyDetail detail = strategyDetailService.get(id);
        StrategyContent content = strategyDetailService.getContent(id);
        detail.setStrategyContent(content);
        model.addAttribute("detail", detail);
        model.addAttribute("vo", strategyStatisVOredisService.viewnumIncrease(id, 1, userInfo));
        //是否收藏
        if (userInfo != null) {
            model.addAttribute("isFavor", strategyStatisVOredisService.selectISFavorByUId(detail.getId(), userInfo.getId()));
        }
        //热度+1
        strategyStatisVOredisService.addHotScore(id, 1);
        return "strategy/detail";
    }

    @RequestMapping("/list")
    public Object list(Model model, @ModelAttribute("qo") StrategyDetailQuery qo) {
        model.addAttribute("pageInfo", strategyDetailService.listByDestId(qo));
        model.addAttribute("toasts", destinationService.getToasts(qo.getDestId()));
        model.addAttribute("dest", destinationService.getById(qo.getDestId()));
        model.addAttribute("tags", strategyTagService.list());

        return "strategy/list";
    }

    @RequestMapping("/commentAdd")
    @ResponseBody
    public Object commentAdd(StrategyComment strategyComment, @UserParam UserInfo userInfo) {
        // 判断是否登录
        if(userInfo==null){
            return new AjaxResult(false,"请先登录!");
        }
        strategyCommentService.saveOrUpdate(strategyComment, userInfo);
        //评论数加1
        StrategyStatisVO vo = strategyStatisVOredisService.replynumIncrease(strategyComment.getDetailId(), 1);
        //热度+1
        strategyStatisVOredisService.addHotScore(strategyComment.getDetailId(), 1);
        return AjaxResult.SUCCESS.addData(vo.getReplynum());
    }

    @RequestMapping("/comment")
    public String comment(Model model, @ModelAttribute("qo") StrategyCommentQuery qo) {
        Page page = strategyCommentService.selectStrategyComment(qo);
        model.addAttribute("page", page);

        return "strategy/commentTpl";
    }

    @RequestMapping("/commentThumbUp")
    @ResponseBody
    public Object commentThumbUp(Model model, String toid, Long fromid) {//评论id,点赞的用户id
        strategyCommentService.commentThumbUp(toid, fromid);
        return AjaxResult.SUCCESS;
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
        boolean b = strategyStatisVOredisService.favor(sid, userInfo);
        if(b){
            strategyStatisVOredisService.addCommendScore(sid, 1);
        }else{
            strategyStatisVOredisService.addCommendScore(sid, -1);
        }
        ajaxResult.setData(strategyStatisVOredisService.selectStrategyStatisVOById(sid));
        ajaxResult.setSuccess(b);
        //国内外攻略热度加1
        return ajaxResult;
    }

    @RequestMapping("/strategyThumbup")
    @ResponseBody
    public Object strategyThumbup(Long sid, @UserParam UserInfo userInfo) {//攻略id
        AjaxResult ajaxResult = new AjaxResult();
        if (userInfo == null) {
            ajaxResult = new AjaxResult(false, "请先登录");
            ajaxResult.setCode(102);
            return ajaxResult;
        }
        boolean b = strategyStatisVOredisService.Thumbup(sid, userInfo.getId());
        ajaxResult.setData(strategyStatisVOredisService.selectStrategyStatisVOById(sid));
        ajaxResult.setSuccess(b);
        //国内外攻略热度加1
        if(b){
            strategyStatisVOredisService.addCommendScore(sid, 1);
        }
        return ajaxResult;
    }


}
