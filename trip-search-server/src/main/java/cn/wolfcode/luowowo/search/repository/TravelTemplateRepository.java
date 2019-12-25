package cn.wolfcode.luowowo.search.repository;

import cn.wolfcode.luowowo.search.domain.TravelTemplate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * spring-data-jpa操作接口
 *
 */
@Repository
public interface TravelTemplateRepository extends ElasticsearchRepository<TravelTemplate,Long>{

    List<TravelTemplate> findByDestName(String destName);
}
