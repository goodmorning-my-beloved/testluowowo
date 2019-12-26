package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.member.service.IUserInfoService;
import cn.wolfcode.luowowo.website.web.annotation.RequireLogin;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserSettingController {

    @Reference
    private IUserInfoService userInfoService;

    @RequestMapping("/setting")
    @RequireLogin
    public String Setting(Model model, @UserParam UserInfo userInfo){
        //回显用户信息
        UserInfo user = userInfoService.get(userInfo.getId());
        model.addAttribute("user",user);
        return "personcenter/setting";
    }


}
