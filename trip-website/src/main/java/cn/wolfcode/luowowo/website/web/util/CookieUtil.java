package cn.wolfcode.luowowo.website.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie操作工具类
 */
public class CookieUtil {

    /**
     * 添加cookie
     * @param response
     * @param name
     * @param value
     * @param timeout
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int timeout){

        //将token封装cookie中, 通过response对象返回到浏览器中
        Cookie cookie = new Cookie(name, value);
        //   /xxx/yyy  添加cookie  : cookie 存在路径区分
        //   /zz
        cookie.setPath("/");  //设置为根路径,表示该cookie任意请求都可以共享
        cookie.setMaxAge(timeout);
        response.addCookie(cookie);
    }

    /**
     * 获取token
     * @param request
     */
    public static String getToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("token")){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
