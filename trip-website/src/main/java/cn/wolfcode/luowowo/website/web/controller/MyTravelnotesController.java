package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.query.TravelQuery;
import cn.wolfcode.luowowo.article.service.ITravelService;
import cn.wolfcode.luowowo.cache.domain.TravelStatisVO;
import cn.wolfcode.luowowo.cache.service.ITravelStatisVOredisService;
import cn.wolfcode.luowowo.cache.service.IUserInfoRedisServcie;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.RequireLogin;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyTravelnotesController {

    @Reference
    private ITravelService travelService;
    @Reference
    private ITravelStatisVOredisService travelStatisVOredisService;
    @Reference
    private IUserInfoRedisServcie userInfoRedisServcie;

    @RequestMapping("mytravelnotes")
    @RequireLogin
    public String mytravelnotes(Model model, @UserParam UserInfo userInfo, @ModelAttribute("qo")TravelQuery qo){
        //用户信息
        model.addAttribute("userInfo",userInfo);
        //用户的游记
        PageInfo pageInfo=travelService.queryByAuthId(qo,userInfo.getId());
        model.addAttribute("pageInfo",pageInfo);
        //游记的总数
        model.addAttribute("count",pageInfo.getSize());
        //游记的总阅读数
        List<Travel> travels = travelService.selectByAuthorId(userInfo.getId());
        long viewnum=0;
        for (Travel travel : travels) {
            TravelStatisVO travelStatisVO = travelStatisVOredisService.selectById(travel.getId());
            viewnum+=travelStatisVO.getViewnum();
        }
        model.addAttribute("viewnum",viewnum);
        //累计访客
        //int num=userInfoRedisServcie.getViewNumByUserId(userInfo.getId());
        model.addAttribute("num",1);
        //今日访客
        return "/personcenter/mytravelnotes";
    }


}
