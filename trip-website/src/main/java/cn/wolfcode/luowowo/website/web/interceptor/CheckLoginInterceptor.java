package cn.wolfcode.luowowo.website.web.interceptor;

import cn.wolfcode.luowowo.cache.service.IUserInfoRedisServcie;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.RequireLogin;
import cn.wolfcode.luowowo.website.web.util.CookieUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 继承跟实现都可以,jdk1.8后用实现,1.8后接口有个默认实现方法
 */
public class CheckLoginInterceptor implements HandlerInterceptor{
    @Reference
    private IUserInfoRedisServcie userInfoRedisServcie;

    //登录控制检查
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //需要注意要判断handler是不是handlermethod的实例,因为静态资源的handler不是这个,其实也不用,因为我们在配置里做了过滤
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod= (HandlerMethod) handler;
            String token = CookieUtil.getToken(request);
            UserInfo user=userInfoRedisServcie.getUserByToken(token);
            if(token!=null){
                //跟新延长时间
                userInfoRedisServcie.setToken(token,user);
                CookieUtil.addCookie(response,"token",token,60*30);
            }
            //判断方法是否贴了我们自定义注解
            if(handlerMethod.hasMethodAnnotation(RequireLogin.class)){
                //如果有,需要检查
                //判断有没登录,拿到key去redis里查
                if(user==null){
                    response.sendRedirect("/login.html");
                    return false;
                }
                //往session存用户信息
                request.getSession().setAttribute("userInfo",user);


            }
        }
        return true;
    }
}
