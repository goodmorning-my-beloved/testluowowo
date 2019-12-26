package cn.wolfcode.luowowo.cache.service.impl;

import cn.wolfcode.luowowo.cache.service.IUserInfoRedisServcie;
import cn.wolfcode.luowowo.cache.util.RedisKeys;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.member.service.IUserInfoService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class UserInfoRedisServiceImpl implements IUserInfoRedisServcie {

    @Autowired
    private StringRedisTemplate template;//约定key跟value必须是String类型
    @Reference
    private IUserInfoService userInfoService;
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

    @Override
    public void updateUserInfo(String token, UserInfo userInfo) {
        UserInfo user = userInfoService.selectById(userInfo.getId());
        template.opsForValue().set(token,JSON.toJSONString(user),30,TimeUnit.MINUTES);
    }

    @Override
    public void setEmailCode(String code, UserInfo userInfo) {
        String key= "EMAILCODE:"+userInfo.getId();
        template.opsForValue().set(key,code, RedisKeys.VERFIYCODE.getTime(), TimeUnit.MINUTES);
    }

    @Override
    public boolean selectEmailCode(UserInfo userInfo, String smscode) {
        //如果不存在,
        String key= "EMAILCODE:"+userInfo.getId();
        if(key==null){
            return false;
        }
        //如果存在,判断是否一致
        String code = template.opsForValue().get(key);
        if(code.equals(smscode)){
            return true;
        }
        return false;
    }

    @Override
    public void deleteUserInfoInRedis(String token) {
        template.delete(token);
    }
}
