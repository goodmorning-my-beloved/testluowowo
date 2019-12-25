package cn.wolfcode.luowowo.article.service;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.domain.Region;
import cn.wolfcode.luowowo.article.query.RegionQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 区域服务
 */
public interface IRegionService {

    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo query(RegionQuery qo);

    /**
     * 添加与更新
     * @param region
     */
    void saveOrUpdate(Region region);

    /**
     * 查询单个
     * @param rid
     * @return
     */
    Region get(Long rid);

    /**
     * 查询热门的区域
     * @return
     */
    List<Region> queryHotRegions();

    /**
     * 改变是否热门
     * @param id
     * @param hot
     */
    void changeHotById(Long id, int hot);

    /**
     * 删除区域
     * @param id
     */
    void deleteById(Long id);


}
