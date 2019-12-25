package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.common.util.AjaxResult;
import cn.wolfcode.luowowo.member.service.IUserInfoService;
import cn.wolfcode.luowowo.website.web.util.CookieUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Reference
    private IUserInfoService userInfoService;

    @RequestMapping("/hello")
    @ResponseBody
    public Object login(Long id) {
        return userInfoService.get(id);
    }

    @RequestMapping("/checkPhone")
    @ResponseBody
    public Object checkPhone(String phone) {
        return !userInfoService.checkPhone(phone);
    }

    @RequestMapping("/sendVerifyCode")
    @ResponseBody
    public Object sendVerifyCode(String phone) throws EmailException {
        //发送验证码
        userInfoService.sendVerifyCode(phone);
        //给前端提示发送成功
        return AjaxResult.SUCCESS;
    }

    @RequestMapping("/userRegist")
    @ResponseBody
    public Object userRegist(String phone, String nickname, String password, String rpassword, String verifyCode) {
        userInfoService.userRegist(phone, nickname, password, rpassword, verifyCode);
        return AjaxResult.SUCCESS;
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public Object userLogin(HttpServletResponse response, String username, String password) {
        //加密
        password= DigestUtils.md5DigestAsHex(password.getBytes());

        String token = userInfoService.selectByUsernameAndPassword(username, password);

        //创建一个cookie,将token设置到cookie上,要设过期时间
        CookieUtil.addCookie(response,"token",token,60*30);
        return AjaxResult.SUCCESS;
    }


}
