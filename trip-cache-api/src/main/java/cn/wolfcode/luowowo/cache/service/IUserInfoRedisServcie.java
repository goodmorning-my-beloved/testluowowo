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

    /**
     * 修改redis中用户信息
     * @param token
     * @param id
     *
     */
    void updateUserInfo(String token, UserInfo id);

    /**
     * 往redis中存邮箱验证码
     * @param code
     * @param userInfo
     */
    void setEmailCode(String code, UserInfo userInfo);

    /**
     * 判断邮箱验证码是否正确
     * @param userInfo
     * @param smscode
     * @return
     */
    boolean selectEmailCode(UserInfo userInfo, String smscode);

    /**
     * 删除redis中的用户信息
     * @param token
     */
    void deleteUserInfoInRedis(String token);
}
