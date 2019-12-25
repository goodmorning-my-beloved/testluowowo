package cn.wolfcode.luowowo.cache.service.impl;

import cn.wolfcode.luowowo.cache.service.IUserInfoRedisServcie;
import cn.wolfcode.luowowo.cache.util.RedisKeys;
import cn.wolfcode.luowowo.common.util.Consts;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class UserInfoRedisServiceImpl implements IUserInfoRedisServcie {

    @Autowired
    private StringRedisTemplate template;//约定key跟value必须是String类型
    @Override
    public void setVerfiyCode(String phone, String code) {
        String key= RedisKeys.VERFIYCODE.join(phone);
        template.opsForValue().set(key,code, RedisKeys.VERFIYCODE.getTime(), TimeUnit.MINUTES);
    }

    @Override
    public String getVerfiyCode(String key) {
        return template.opsForValue().get(key);
    }

    @Override
    public void setverifyCodeVali(String key) {
        template.opsForValue().set(key,"验证码防刷控制",1L,TimeUnit.MINUTES);
    }

    @Override
    public void setToken(String token, UserInfo userInfo) {
        //把value转为json格式字符串
        String jsonUserInfo = JSON.toJSONString(userInfo);
        template.opsForValue().set(token,jsonUserInfo,30,TimeUnit.MINUTES);
    }

    @Override
    public UserInfo getUserByToken(String token) {
        if(token==null){
            return null;
        }
        String s = template.opsForValue().get(token);
        //转成对象
        if(s==null){
            return null;
        }
        UserInfo user = JSON.parseObject(s, UserInfo.class);


        return user;

    }
}
