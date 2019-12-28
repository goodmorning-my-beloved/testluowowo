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

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public int facousAndFans(Long userId, Long facousId) {
        //1表示关注,2表示取消,3表示自己关注自己
        //先判断两个id是否相等,相等不能关注,3
        if(userId==facousId){
            return 3;
        }
        //判断当前用户有没有关注过,就是看被关注用户的粉丝里有没有这个用户
        String facousKey = RedisKeys.USER_FANS_COOLECTION.join(String.valueOf(facousId));//被关注的key
        String userKey = RedisKeys.USER_FOCUS_COOLECTION.join(String.valueOf(userId));//用户key
        if(!template.hasKey(facousKey)){
            //没有被任何人关注的时候
            //不存在,添加,返回1
            List<Long> list=new ArrayList<>();
            list.add(userId);
            template.opsForValue().set(facousKey,JSON.toJSONString(list));
            //用户里面设置关注了谁
            if(!template.hasKey(userKey)){
                //不存在,表示没有关注任何人
                List<Long> userlist=new ArrayList<>();
                userlist.add(facousId);
                template.opsForValue().set(userKey,JSON.toJSONString(userlist));
            }else{
                //如果存在
                String suserList = template.opsForValue().get(userKey);
                List<Long> longs = JSON.parseArray(suserList, Long.TYPE);
                longs.add(facousId);
                template.opsForValue().set(userKey,JSON.toJSONString(longs));
            }
            return 1;
        }
        //如果存在,判断有没有这个用户
        String sList = template.opsForValue().get(facousKey);
        List<Long> list = JSON.parseArray(sList, Long.TYPE);
        if(!list.contains(userId)){
            //不存在
            list.add(userId);
            template.opsForValue().set(facousKey,JSON.toJSONString(list));
            //用户里加进去
            //用户里面设置关注了谁
            if(!template.hasKey(userKey)){
                //不存在,表示没有关注任何人
                List<Long> userlist=new ArrayList<>();
                userlist.add(facousId);
                template.opsForValue().set(userKey,JSON.toJSONString(userlist));
            }else{
              //如果存在
              String suserList = template.opsForValue().get(userKey);
              List<Long> longs = JSON.parseArray(suserList, Long.TYPE);
              longs.add(facousId);
              template.opsForValue().set(userKey,JSON.toJSONString(longs));
            }
            return 1;
        }else {
            //如果粉丝里存在这个用户,则是取消操作
            list.remove(userId);
            List<Long> userFacous = JSON.parseArray(template.opsForValue().get(userKey), Long.TYPE);
            userFacous.remove(facousId);
            template.opsForValue().set(facousKey, JSON.toJSONString(list));
            template.opsForValue().set(userKey, JSON.toJSONString(userFacous));
            return 2;
        }
    }

    @Override
    public boolean isFacous(Long userId, Long facousId) {
        String userKey = RedisKeys.USER_FOCUS_COOLECTION.join(String.valueOf(userId));//用户key
        if(!template.hasKey(userKey)){
            return false;
        }
        List<Long> list = JSON.parseArray(template.opsForValue().get(userKey), Long.TYPE);
        if(list.contains(facousId)){
            return true;
        }
        return false;
    }

    @Override
    public List<Long> getFacousSum(Long id) {
        String key = RedisKeys.USER_FOCUS_COOLECTION.join(String.valueOf(id));//用户key
        if(!template.hasKey(key)){
            return new ArrayList<>();
        }
        return JSON.parseArray(template.opsForValue().get(key),Long.TYPE);
    }

    @Override
    public int getFansNum(Long id) {
        String key = RedisKeys.USER_FANS_COOLECTION.join(String.valueOf(id));//用户key
        if(!template.hasKey(key)){
            return 0;
        }
        return JSON.parseArray(template.opsForValue().get(key),Long.TYPE).size();
    }
}
