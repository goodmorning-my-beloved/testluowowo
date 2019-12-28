package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.article.service.ITravelService;
import cn.wolfcode.luowowo.cache.domain.TravelStatisVO;
import cn.wolfcode.luowowo.cache.service.ITravelStatisVOredisService;
import cn.wolfcode.luowowo.cache.service.IUserInfoRedisServcie;
import cn.wolfcode.luowowo.comment.domain.TravelComment;
import cn.wolfcode.luowowo.comment.service.ITravelCommentService;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.member.service.IUserInfoService;
import cn.wolfcode.luowowo.website.web.annotation.RequireLogin;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import cn.wolfcode.luowowo.website.web.util.CookieUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mine")
public class HomePageController {

    @Reference
    private ITravelService travelService;
    @Reference
    private IDestinationService destinationService;
    @Reference
    private ITravelCommentService travelCommentService;
    @Reference
    private ITravelStatisVOredisService travelStatisVOredisService;
    @Reference
    private IUserInfoRedisServcie userInfoRedisServcie;
    @Reference
    private IUserInfoService userInfoService;

    @RequireLogin
    @RequestMapping("/home")
    public String home(Model model, @UserParam UserInfo user){

        UserInfo userInfo = userInfoService.get(user.getId());
        model.addAttribute("userInfo",userInfo);

        //右边我的游记
        List<Travel> list=travelService.selectByAuthorId(userInfo.getId());
        Map<String,Object> map=null;
        List<Map> travel2Comment=new ArrayList<>();
        for (Travel travel : list) {
            map=new HashMap<>();
            List<TravelComment> travelComments = travelCommentService.selectCommentByTravelId(travel.getId());
            map.put("travel",travel);
            map.put("travelComments",travelComments);
            //每篇游记对应的父目的地
            Destination parentDest = destinationService.getToasts(travel.getDest().getId()).get(0);
            //每篇游记的点赞数
            TravelStatisVO travelStatisVO = travelStatisVOredisService.selecttravelStatisVOById(travel.getId());
            map.put("travelStatisVO",travelStatisVO);
            map.put("parentDest",parentDest);
            travel2Comment.add(map);
        }
        model.addAttribute("travels",travel2Comment);
        //游记总数
        model.addAttribute("sum",list.size());
        //左边用户信息
        model.addAttribute("userInfo",userInfo);
        //我的关注总数
        //我的关注用户的头像,昵称
        //我的粉丝总数
        List<Long> facous=userInfoRedisServcie.getFacousSum(user.getId());
        model.addAttribute("facousNum",facous.size());
        List<UserInfo> userFacousInfo=new ArrayList<>();
        for (Long id : facous) {
            UserInfo info = userInfoService.get(id);
            userFacousInfo.add(info);
        }
        model.addAttribute("userFacousInfo",userFacousInfo);

        int fansNum=userInfoRedisServcie.getFansNum(user.getId());
        model.addAttribute("fansNum",fansNum);
        return "/personcenter/homepage";
    }




}
