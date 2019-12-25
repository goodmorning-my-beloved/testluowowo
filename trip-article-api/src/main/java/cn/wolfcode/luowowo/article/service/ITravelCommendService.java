package cn.wolfcode.luowowo.article.service;


import cn.wolfcode.luowowo.article.domain.TravelCommend;
import cn.wolfcode.luowowo.article.query.TravelCommendQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 游记推荐服务
 */
public interface ITravelCommendService {

    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo query(TravelCommendQuery qo);


    /**
     * 添加/更新
     * @param travelCommend
     */
    void saveOrUpdate(TravelCommend travelCommend);

    /**
     * 查询所有
     * @return
     */
    List<TravelCommend> list();

    /**
     * 查单个
     * @param sid
     * @return
     */
    TravelCommend get(Long sid);

    /**
     * 删除游记推荐
     * @param id
     */
    void deleteById(long id);

    /**
     * 查询指定排名的推荐
     * @param num
     * @return
     */
    List<TravelCommend> queryTop(int num);
}
