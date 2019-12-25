package cn.wolfcode.luowowo.cache.service;

import cn.wolfcode.luowowo.member.domain.UserInfo;

public interface IUserInfoRedisServcie {
    /**
     * 添加验证码
     * @param phone
     * @param code
     */
    void setVerfiyCode(String phone, String code);

    /**
     * 根据key查询value
     * @param key
     * @return
     */
    String getVerfiyCode(String key);

    /**
     * 设置间隔,防刷
     * @param key
     */
    void setverifyCodeVali(String key);

    /**
     * 登录储存用户信息
     * @param token
     * @param userInfo
     */
    void setToken(String token, UserInfo userInfo);

    /**
     * 根据token查对象
     * @param token
     * @return
     */
    UserInfo getUserByToken(String token);
}
