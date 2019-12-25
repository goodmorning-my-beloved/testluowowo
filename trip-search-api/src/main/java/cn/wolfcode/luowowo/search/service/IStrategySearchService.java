package cn.wolfcode.luowowo.search.service;


import cn.wolfcode.luowowo.search.domain.StrategyTemplate;
import cn.wolfcode.luowowo.search.query.SearchQueryObject;
import cn.wolfcode.luowowo.search.vo.StatisVO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * es中攻略的搜索服务
 */
public interface IStrategySearchService {

    public void saveOrUpdate(StrategyTemplate strategyTemplate);

    /**
     * 查询主题排行前10
     * @return
     */
    List<Map<String,Object>> queryThemeTop10();

    /**
     * 查询主题
     * @return
     */
    List<StatisVO> queryConditionThemeGroup();

    /**
     * 查询城市
     * @return
     */
    List<StatisVO>  queryConditionProvincesGroup();

    List<StatisVO>  queryConditionAbroadsGroup();

    Page query(SearchQueryObject qo);

    /**
     * 根据目的地名查攻略
     * @param name
     * @return
     */
    List<StrategyTemplate> selectByDestName(String name);
}
