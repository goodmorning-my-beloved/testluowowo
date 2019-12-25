package cn.wolfcode.luowowo.search.repository;

import cn.wolfcode.luowowo.search.domain.StrategyTemplate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * spring-data-jpa操作接口
 *
 */
@Repository
public interface StrategyTemplateRepository extends ElasticsearchRepository<StrategyTemplate,Long>{
    List<StrategyTemplate> findByThemeId(Long themeId);

    List<StrategyTemplate> findByDestName(String name);
}
