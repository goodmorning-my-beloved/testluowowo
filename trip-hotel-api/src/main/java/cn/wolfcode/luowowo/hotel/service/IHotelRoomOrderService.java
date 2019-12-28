package cn.wolfcode.luowowo.hotel.service;

import cn.wolfcode.luowowo.hotel.domain.HotelRoomOrder;
import cn.wolfcode.luowowo.hotel.domain.HotelRoomType;
import cn.wolfcode.luowowo.hotel.query.HotelQuery;

import java.util.List;

public interface IHotelRoomOrderService {
    /**
     * 根据酒店类型id,查找酒店某种类型房间的订单
     * @param hotelTypeId
     * @return
     */
    List<HotelRoomOrder> queryHotelRoomOrderByHotelRoomTypeId(Long hotelTypeId);

    /**
     * 查询在用户输入的时间范围内,酒店的每个房型是否已售罄,
     * @param qo
     * @param roomTypeId
     * @return true 代表房型没有售罄,false代表房型售罄
     */
    Boolean checkSoldOut(HotelQuery qo, HotelRoomType roomTypeId);

    void save(HotelRoomOrder hotelRoomOrder);

    /**
     * 根据用户id查询用户拥有的订单
     * @param userId
     * @return
     */
    List<HotelRoomOrder> queryHotelOrderByUserId(Long userId);
}
