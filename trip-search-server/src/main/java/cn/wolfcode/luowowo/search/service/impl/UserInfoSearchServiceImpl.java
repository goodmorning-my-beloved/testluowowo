package cn.wolfcode.luowowo.search.service.impl;

import cn.wolfcode.luowowo.search.domain.UserInfoTemplate;
import cn.wolfcode.luowowo.search.repository.UserInfoTemplateRepository;
import cn.wolfcode.luowowo.search.service.IUserInfoSearchService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.List;

@Service
public class UserInfoSearchServiceImpl implements IUserInfoSearchService {

    //es 依然使用spring-data-jpa

    //repository 封装了template
    //template 封装了 client

    @Autowired
    private UserInfoTemplateRepository repository;
    @Autowired
    private ElasticsearchTemplate template;

    @Override
    public void saveOrUpdate(UserInfoTemplate userInfoTemplate) {
        repository.save(userInfoTemplate);
    }

    @Override
    public List<UserInfoTemplate> selectByDestName(String name) {
        return repository.findByDestName(name);
    }
}
