package cn.wolfcode.luowowo.search.service;


import cn.wolfcode.luowowo.search.domain.TravelTemplate;

import java.util.List;

/**
 * es中游记的搜索服务
 */
public interface ITravelSearchService {

    /**
     * 增加
     * @param tt
     */
    void save(TravelTemplate tt);

    /**
     * 根据目的地查游记
     * @return
     */
    List<TravelTemplate> selectByDestName(String destName);
}
