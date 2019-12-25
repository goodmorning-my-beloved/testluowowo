package cn.wolfcode.luowowo.cache.service;

import cn.wolfcode.luowowo.cache.domain.TravelStatisVO;

public interface ITravelStatisVOredisService {

    /**
     * 阅读数加1
     */
    void viewnumIncrease(Long id);


    /**
     * 查询对应的游记VO
     * @param id
     * @return
     */
    TravelStatisVO selectById(Long id);
}
