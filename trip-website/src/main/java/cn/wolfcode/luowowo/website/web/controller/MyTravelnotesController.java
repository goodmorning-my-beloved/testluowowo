package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.query.TravelQuery;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.article.service.ITravelService;
import cn.wolfcode.luowowo.cache.domain.TravelStatisVO;
import cn.wolfcode.luowowo.cache.service.ITravelStatisVOredisService;
import cn.wolfcode.luowowo.cache.service.IUserInfoRedisServcie;
import cn.wolfcode.luowowo.comment.domain.TravelComment;
import cn.wolfcode.luowowo.comment.service.ITravelCommentService;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.RequireLogin;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyTravelnotesController {

    @Reference
    private ITravelService travelService;
    @Reference
    private ITravelStatisVOredisService travelStatisVOredisService;
    @Reference
    private IUserInfoRedisServcie userInfoRedisServcie;
    @Reference
    private IDestinationService destinationService;
    @Reference
    private ITravelCommentService travelCommentService;

    @RequestMapping("mytravelnotes")
    @RequireLogin
    public String mytravelnotes(Model model, @UserParam UserInfo userInfo, @ModelAttribute("qo")TravelQuery qo){
        //用户信息
        model.addAttribute("userInfo",userInfo);
        //用户的游记
        PageInfo pageInfo=travelService.queryByAuthId(qo,userInfo.getId());
        //游记的总数
        model.addAttribute("count",pageInfo.getSize());
        //游记的总阅读数
        long viewnum=0;
        //游记的回复数
        int reply=0;
        //父目的地
        List<Travel> list = pageInfo.getList();
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
            //总阅读数
            int thumbsupnum = travelStatisVOredisService.selectById(travel.getId()).getViewnum();
            viewnum+=thumbsupnum;
            //总回复数
            reply+=travelCommentService.selectCommentByTravelId(travel.getId()).size();
        }
        model.addAttribute("travels",travel2Comment);
        model.addAttribute("viewnum",viewnum);
        model.addAttribute("reply",reply);
        //累计访客
        //int num=userInfoRedisServcie.getViewNumByUserId(userInfo.getId());

        model.addAttribute("num",1);
        //今日访客
        return "/personcenter/mytravelnotes";
    }


}
