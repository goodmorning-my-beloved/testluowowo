package cn.wolfcode.luowowo.search.repository;

import cn.wolfcode.luowowo.search.domain.DestinationTemplate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


/**
 * spring-data-jpa操作接口
 *
 */
@Repository
public interface DestinationTemplateRepository extends ElasticsearchRepository<DestinationTemplate,Long>{

    DestinationTemplate findByName(String name);
}
