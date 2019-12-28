package cn.wolfcode.luowowo.hotel.service;

import cn.wolfcode.luowowo.hotel.domain.HotelRoomType;

import java.util.List;

public interface IHotelRoomTypeService {
    /**
     * 根据酒店的id,查出酒店有什么类型的房间
     * @param hotelId
     * @return
     */
    List<HotelRoomType> queryHotelRoomTypeByHotelId(Long hotelId);

    /**
     * 通过主键查询单个类型
     * @param hotelRoomTypeId
     * @return
     */
    HotelRoomType getHotelRoomTypeById(Long hotelRoomTypeId);
}
