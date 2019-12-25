package cn.wolfcode.luowowo.search.service;


import cn.wolfcode.luowowo.search.domain.UserInfoTemplate;

import java.util.List;

/**
 * es中用户的搜索服务
 */
public interface IUserInfoSearchService {

    public void saveOrUpdate(UserInfoTemplate userInfoTemplate);

    /**
     *
     * @param name
     * @return
     */
    List<UserInfoTemplate> selectByDestName(String name);
}
