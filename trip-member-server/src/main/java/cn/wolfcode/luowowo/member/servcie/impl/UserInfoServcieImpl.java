package cn.wolfcode.luowowo.member.servcie.impl;

import cn.wolfcode.luowowo.cache.service.IUserInfoRedisServcie;
import cn.wolfcode.luowowo.cache.util.RedisKeys;
import cn.wolfcode.luowowo.common.exception.LogicException;
import cn.wolfcode.luowowo.common.util.AssertUtil;
import cn.wolfcode.luowowo.common.util.Consts;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.member.mapper.UserInfoMapper;
import cn.wolfcode.luowowo.member.service.IUserInfoService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class UserInfoServcieImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Reference
    private IUserInfoRedisServcie userInfoRedisServcie;

    @Override
    public UserInfo get(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean checkPhone(String phone) {
        int count = userInfoMapper.selectCountByPhone(phone);
        return count > 0;
    }

    @Override
    public void sendVerifyCode(String phone) throws EmailException, LogicException {
        //防刷
        if (userInfoRedisServcie.getVerfiyCode(RedisKeys.VERFIYCODEVALI.getVerifyCodeVali()) != null) {
            throw new LogicException("防刷!!");
        }

        //创建验证码
        String code = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 4);
        //将验证码存到redis中
        userInfoRedisServcie.setVerfiyCode(phone, code);
        userInfoRedisServcie.setverifyCodeVali(RedisKeys.VERFIYCODEVALI.getVerifyCodeVali());//设置发送频率,防刷
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


    }

    @Override
    public void userRegist(String phone, String nickname, String password, String rpassword, String verifyCode) throws LogicException {
        //判断参数是否为空
        AssertUtil.hasLength(phone, "手机号不能为空");
        AssertUtil.hasLength(nickname, "昵称不能为空");
        AssertUtil.hasLength(password, "密码不能为空");
        AssertUtil.hasLength(rpassword, "确认密码是否一致不能为空");
        AssertUtil.hasLength(verifyCode, "验证码不能为空");
        //判断2次输入的密码是否一致
        AssertUtil.isEquals(password, rpassword, "两次输入的密码不一致");
        //判断手机号格式是否正确
        String regex = "^(1)\\d{10}$";
        if (!Pattern.matches(regex, phone)) {
            throw new LogicException("手机号码不合法");
        }
        //判断手机号的唯一性
        if (checkPhone(phone)) {
            throw new LogicException("手机号已被注册");
        }
        //判断验证码是否正确
        String key =  RedisKeys.VERFIYCODE.join(phone);
        String value = userInfoRedisServcie.getVerfiyCode(key);
        if (value == null || !value.equals(verifyCode)) {
            throw new LogicException("验证码错误或者超过有效时间");
        }
        //注册
        UserInfo userInfo = new UserInfo();
        //头像给个默认
        userInfo.setHeadImgUrl("/images/default.jpg");
        //给个默认会员等级
        userInfo.setLevel(1);
        userInfo.setNickname(nickname);
        //密码加密
        //password = password + nickname;
        String MD5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        userInfo.setPassword(MD5Password);
        userInfo.setPhone(phone);
        //账号状态
        userInfo.setState(UserInfo.STATE_NORMAL);
        userInfoMapper.insert(userInfo);

    }

    @Override
    public String selectByUsernameAndPassword(String username, String password)throws LogicException {
        //判断参数
        AssertUtil.hasLength(username, "用户名不能为空");
        AssertUtil.hasLength(password, "密码不能为空");
        //查用户是否存在
        UserInfo userInfo=userInfoMapper.selectByUsernameAndPassword(username,password);
        if(userInfo==null){
            throw new LogicException("用户名或密码错误");
        }
        //创建一个唯一token
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        //将token作redis中的key,value是登录用户对象,存到redis缓存数据库中,并设置过时时间
        userInfoRedisServcie.setToken(token,userInfo);
        //返回token到表现层进行cookie相关操作
        return token;
    }

    @Override
    public List<UserInfo> list() {

        return userInfoMapper.selectAll();
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public UserInfo selectById(Long id) {

        return userInfoMapper.selectById(id);
    }

    @Override
    public void updatePassword(Long id, String password) {
        userInfoMapper.updatePassword(id,password);
    }

    @Override
    public void updateUserImg(String headImgUrl, Long id) {
        userInfoMapper.updateUserImg(headImgUrl,id);
    }


}
