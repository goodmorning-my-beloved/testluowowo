package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.RequireLogin;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

    @RequestMapping("/review")
    @RequireLogin
    public String review(Model model, @UserParam UserInfo userInfo){
        //用户信息
        model.addAttribute("userInfo",userInfo);
        return "/personcenter/review";
    }
}
