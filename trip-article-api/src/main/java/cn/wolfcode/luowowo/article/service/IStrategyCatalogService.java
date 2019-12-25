package cn.wolfcode.luowowo.article.service;


import cn.wolfcode.luowowo.article.domain.StrategyCatalog;
import cn.wolfcode.luowowo.article.query.StrategyCatalogQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 攻略分类服务
 */
public interface IStrategyCatalogService {

    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo query(StrategyCatalogQuery qo);

    /**
     * 添加/更新
     * @param strategyCatalog
     */
    void saveOrUpdate(StrategyCatalog strategyCatalog);

    /**
     * 查单个
     * @param id
     * @return
     */
    StrategyCatalog get(Long id);

    /**
     * 删除攻略分类
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据攻略查询攻略分类
     * @param strategyId
     * @return
     */
    List<StrategyCatalog> selectCatalogByStrategyId(Long strategyId);

    /**
     * 根据目的地查攻略分类
     * @param id
     * @return
     */
    List<StrategyCatalog> selectCatalogByDestId(Long id);

}
