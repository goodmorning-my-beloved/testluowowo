package cn.wolfcode.luowowo.hotel.service;

import cn.wolfcode.luowowo.hotel.domain.HotelRegion;

import java.util.List;

public interface IHotelRegionService {
    /**
     * 通过目的地查询目的地下所有的区域的酒店即区域相关信息
     * @return
     */
    List<HotelRegion> queryAllHotelRegionByDestId(Long destId);

    HotelRegion getByPrimaryId(Long id);
}
