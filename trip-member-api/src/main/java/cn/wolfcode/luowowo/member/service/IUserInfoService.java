package cn.wolfcode.luowowo.member.service;

import cn.wolfcode.luowowo.common.exception.LogicException;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import org.apache.commons.mail.EmailException;

import java.util.List;

public interface IUserInfoService {
    /**
     * 查询单个用户
     * @param id
     * @return
     */
    UserInfo get(Long id);

    /**
     * 判断手机号是否存在
     * @param phone
     * @return true:存在 false:不存在
     */
    boolean checkPhone(String phone);

    /**
     * 发送验证码
     * @param phone
     */
    void sendVerifyCode(String phone) throws EmailException,LogicException;

    /**
     * 用户注册接口
     * @param phone
     * @param nickname
     * @param password
     * @param rpassword
     * @param verifyCode
     */
    void userRegist(String phone, String nickname, String password, String rpassword, String verifyCode)throws LogicException;

    /**
     * 登录检查
     * @param username
     * @param password
     * @return
     */
    String selectByUsernameAndPassword(String username, String password)throws LogicException;


    List<UserInfo> list();

    /**
     * 跟新设置用户信息
     * @param userInfo
     */
    void updateUserInfo(UserInfo userInfo);

    /**
     * 根据id查用户,用来在redis中储存用户信息
     * @param id
     * @return
     */
    UserInfo selectById(Long id);

    /**
     * 更改密码
     * @param id
     * @param password
     */
    void updatePassword(Long id, String password);
}
