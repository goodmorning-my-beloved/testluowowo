package cn.wolfcode.luowowo.website.web.Resolver;

import cn.wolfcode.luowowo.cache.service.IUserInfoRedisServcie;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import cn.wolfcode.luowowo.website.web.util.CookieUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户对象解析器
 * 将cooike中token值解析成userinfo对象,并注入到请求映射参数中
 */
public class UserInfoArgumentResolver implements HandlerMethodArgumentResolver {

    @Reference
    private IUserInfoRedisServcie userInfoRedisServcie;

    /**
     * 该解析器支持解析的参数类型
     * 这里支持userinfo
     * @param methodParameter
     * @return true表示支持,false表示不支持
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType()== UserInfo.class
                &&methodParameter.hasParameterAnnotation(UserParam.class);
    }

    /**
     * 一旦supportsParameter返回true,表示该解析器启动了,需要解析`对应的参数
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        String token = CookieUtil.getToken(nativeWebRequest.getNativeRequest(HttpServletRequest.class));
        UserInfo userInfo = userInfoRedisServcie.getUserByToken(token);
        return userInfo;
    }
}
