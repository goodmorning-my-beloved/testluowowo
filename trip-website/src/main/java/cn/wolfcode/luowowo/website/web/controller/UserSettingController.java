package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.cache.service.IUserInfoRedisServcie;
import cn.wolfcode.luowowo.cache.util.RedisKeys;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import cn.wolfcode.luowowo.common.util.Consts;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.member.service.IUserInfoService;
import cn.wolfcode.luowowo.website.web.annotation.RequireLogin;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import cn.wolfcode.luowowo.website.web.util.CookieUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class UserSettingController {

    @Reference
    private IUserInfoService userInfoService;
    @Reference
    private IUserInfoRedisServcie userInfoRedisServcie;

    @RequestMapping("/setting")
    @RequireLogin
    public String Setting(Model model, @UserParam UserInfo userInfo){
        //回显用户信息
        UserInfo user = userInfoService.get(userInfo.getId());
        model.addAttribute("user",user);
        return "personcenter/setting";
    }

    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public Object updateUserInfo(HttpServletRequest request,UserInfo userInfo, @UserParam UserInfo user){
        if(user==null){
            return new AjaxResult(false,"请先登录");
        }
        userInfo.setId(user.getId());
        userInfoService.updateUserInfo(userInfo);
        //修改redis中的用户数据
        String token = CookieUtil.getToken(request);
        userInfoRedisServcie.updateUserInfo(token,user);
        return AjaxResult.SUCCESS;
    }

    //邮箱验证
    @RequestMapping("/sendEmail")
    @ResponseBody
    public Object sendEmail(@UserParam UserInfo userInfo)throws  Exception{
        //创建验证码
        String code = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 4);
        //将验证码存到redis中
        userInfoRedisServcie.setEmailCode(code,userInfo);
        //发送短信
        System.out.println("验证码是" + code + "有效时间是" + RedisKeys.VERFIYCODE.getTime() + "分钟");
        //------------------------------------
        HtmlEmail email = new HtmlEmail();//创建一个HtmlEmail实例对象
        email.setHostName("smtp.qq.com");//邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
        email.setCharset("utf-8");//设置发送的字符类型

        email.addTo("zyr245609184@163.com");//设置收件人
        email.setFrom("245609184@qq.com", "aa");//发送人的邮箱为自己的，用户名可以随便填
        email.setAuthentication("245609184@qq.com", "bgndikrnaznvbjcg");//设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
        email.setSubject("验证码");//设置发送主题
        email.setMsg("验证码是" + code + "有效时间是" + Consts.VERIFY_CODE_VAI_TIME + "分钟");//设置发送内容
        email.send();//进行发送

        return AjaxResult.SUCCESS;
    }

    @RequestMapping("/setpassword")
    public String setpassword(){
        return "/personcenter/setpassword";
    }
    @RequestMapping("updatepassword")
    @ResponseBody
    public Object updatepassword(HttpServletRequest request,@UserParam UserInfo userInfo,String password,String smscode){
        boolean b=userInfoRedisServcie.selectEmailCode(userInfo,smscode);
        if(b){
            //更改密码,删除redis中的数据,
            //加密
            password= DigestUtils.md5DigestAsHex(password.getBytes());
            userInfoService.updatePassword(userInfo.getId(),password);
            //删除redis中的数据
            String token = CookieUtil.getToken(request);
            userInfoRedisServcie.deleteUserInfoInRedis(token);
            return AjaxResult.SUCCESS;
        }
        return new AjaxResult(false,"验证码失效或者错误");

    }
    @RequestMapping("/updateUserImg")
    @ResponseBody
    public Object updateUserImg(HttpServletRequest request,String headImgUrl,@UserParam UserInfo userInfo){
        //数据库更新
        userInfoService.updateUserImg(headImgUrl,userInfo.getId());
        //redis中更新
        String token = CookieUtil.getToken(request);
        userInfoRedisServcie.updateUserInfo(token,userInfo);
        return AjaxResult.SUCCESS;
    }

}
