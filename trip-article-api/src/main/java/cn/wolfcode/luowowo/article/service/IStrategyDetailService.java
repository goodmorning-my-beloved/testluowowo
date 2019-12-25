package cn.wolfcode.luowowo.article.service;


import cn.wolfcode.luowowo.article.domain.StrategyContent;
import cn.wolfcode.luowowo.article.domain.StrategyDetail;
import cn.wolfcode.luowowo.article.query.StrategyDetailQuery;
import cn.wolfcode.luowowo.article.vo.StrategyStatisPersistenceVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 攻略明细服务
 */
public interface IStrategyDetailService {
    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo query(StrategyDetailQuery qo);
    /**
     * 查询所有
     * @return
     */
    List<StrategyDetail> list();
    /**
     * 查单个
     * @param id
     * @return
     */
    StrategyDetail get(Long id);

    /**
     * 增加或修改攻略文章
     * @param detail
     * @param tags
     */
    void saveOrUpdate(StrategyDetail detail, String tags);

    /**
     * 查询内容
     * @param id
     * @return
     */
    StrategyContent getContent(Long id);

    /**
     * 更改发布状态
     * @param state
     * @param id
     */
    void changeState(Long state, Long id);

    /**
     * 删除文章
     * @param id
     */
    void delete(Long id);

    /**
     * 根据目的地查询指定的前三篇攻略明细
     * @param destId
     * @return
     */
    List<StrategyDetail> queryDetailsTop3ByDestId(Long destId);

    /**
     * 根据目的地id查攻略明细,返回分页封装
     * @param qo
     * @return
     */
    PageInfo listByDestId(StrategyDetailQuery qo);

    /**
     * 跟新统计数据
     * @param pvo
     */
    void updateStatis(StrategyStatisPersistenceVO pvo);
}
