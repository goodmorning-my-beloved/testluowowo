package cn.wolfcode.luowowo.member.mapper;

import cn.wolfcode.luowowo.common.exception.LogicException;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    List<UserInfo> selectAll();

    int updateByPrimaryKey(UserInfo record);

    int selectCountByPhone(String phone);

    UserInfo selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    void updateUserInfo(UserInfo userInfo);

    UserInfo selectById(Long id);

    void updatePassword(@Param("id") Long id, @Param("password") String password);
}