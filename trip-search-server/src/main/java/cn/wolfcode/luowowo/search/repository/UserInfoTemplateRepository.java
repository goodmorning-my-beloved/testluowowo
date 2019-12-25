package cn.wolfcode.luowowo.search.repository;

import cn.wolfcode.luowowo.search.domain.UserInfoTemplate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * spring-data-jpa操作接口
 *
 */
@Repository
public interface UserInfoTemplateRepository extends ElasticsearchRepository<UserInfoTemplate,Long>{
    List<UserInfoTemplate> findByDestName(String name);
}
