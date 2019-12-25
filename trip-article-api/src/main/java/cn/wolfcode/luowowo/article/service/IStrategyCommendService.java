package cn.wolfcode.luowowo.article.service;


import cn.wolfcode.luowowo.article.domain.Strategy;
import cn.wolfcode.luowowo.article.domain.StrategyCommend;
import cn.wolfcode.luowowo.article.query.StrategyCommendQuery;
import cn.wolfcode.luowowo.article.query.StrategyQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 攻略推荐服务
 */
public interface IStrategyCommendService {

    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo query(StrategyCommendQuery qo);


    /**
     * 添加/更新
     * @param strategyCommend
     */
    void saveOrUpdate(StrategyCommend strategyCommend);

    /**
     * 查询所有
     * @return
     */
    List<StrategyCommend> list();

    /**
     * 查单个
     * @param sid
     * @return
     */
    StrategyCommend get(Long sid);

    /**
     * 删除攻略推荐
     * @param id
     */
    void deleteById(long id);

    /**
     * 查询指定排名的推荐
     * @param num
     * @return
     */
    List<StrategyCommend> queryTop(int num);
}
