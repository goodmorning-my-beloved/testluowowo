package cn.wolfcode.luowowo.article.service;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.query.DestinationQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 目的的服务
 */
public interface IDestinationService {

    /**
     * 通过层次查询目的地
     * @param deep
     * @return
     */
    List<Destination> getDestsByDeep(int deep);


    /**
     * 添加或更新
     * @param destination
     */
    void saveOrUpdate(Destination destination);

    /**
     * 关联的目的地集合
     * @param rid
     * @return
     */
    List<Destination> getDestByRegionId(Long rid);

    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo query(DestinationQuery qo);

    /**
     * 查询导航吐司
     * @param parentId
     * @return
     */
    List<Destination> getToasts(Long parentId);

    /**
     * 通过目的地获取该目的地的国家
     * @param id
     * @return
     */
    Destination getCountry(Long id);

    /**
     * 获取省份
     * @param id
     * @return
     */
    Destination getProvince(Long id);

    /**
     * 查询所有
     * @return
     */
    List<Destination> list();

    /**
     * 根据区域id查询对应的目的地及其子目的地
     * @param regionId
     * @return
     */
    List<Destination> getHotDestByRegionId(Long regionId);

    /**
     * 修改热门状态
     * @param id
     * @param hot
     */
    void changeHotValue(Long id, int hot);

    /**
     * 自己再做一遍的面包屑实现
     * @param parentId
     * @return
     */
    List<Destination> getToast2s(Long parentId);

    /**
     * 删除目的地
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据id查目的地
     * @param destId
     * @return
     */
    Destination getById(Long destId);






    /**
     * 根据id查目的地,只需查 id 和 name
     * @param id
     * @return
     */
    Destination getByIdOfNameAndId(Long id);


    /**
     * 根据酒住宿,查找到符合主题住宿的目的地集
     * @param themeId 酒店主题id
     * @return
     */
    List<Destination> getByHotelThemeId(Long themeId);

    /**
     * 根据目的地名称查询目的地
     * @param name
     * @return
     */
    Destination getByDestName(String name);
}
