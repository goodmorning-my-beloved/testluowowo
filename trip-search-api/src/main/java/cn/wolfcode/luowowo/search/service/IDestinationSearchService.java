package cn.wolfcode.luowowo.search.service;


import cn.wolfcode.luowowo.search.domain.DestinationTemplate; /**
 * es中游记的搜索服务
 */
public interface IDestinationSearchService {

    /**
     * 新增
     * @param tt
     */
    void save(DestinationTemplate tt);

    /**
     * 根据名字名字精确查询
     * @param name
     * @return
     */
    DestinationTemplate getByName(String name);
}
