package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.cache.service.ITravelStatisVOredisService;
import cn.wolfcode.luowowo.comment.domain.TravelComment;
import cn.wolfcode.luowowo.comment.service.IStrategyCommentService;
import cn.wolfcode.luowowo.comment.service.ITravelCommentService;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.RequireLogin;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ReviewController {

    @Reference
    private ITravelStatisVOredisService travelStatisVOredisService;
    @Reference
    private ITravelCommentService travelCommentService;
    @Reference
    private IStrategyCommentService strategyCommentService;

    @RequestMapping("/review")
    @RequireLogin
    public String review(Model model, @UserParam UserInfo userInfo){
        //用户信息
        model.addAttribute("userInfo",userInfo);
        //查询用户的点评攻略数
        int commentNum=travelStatisVOredisService.selectUserCommentNum(userInfo.getId());
        model.addAttribute("commentNum",commentNum);
        //查询用户点评的的游记
        List<TravelComment> comments=travelCommentService.selectCommentByUserid(userInfo.getId());
        //页面需要游记的封面
        model.addAttribute("comments",comments);
        return "/personcenter/review";
    }
}
