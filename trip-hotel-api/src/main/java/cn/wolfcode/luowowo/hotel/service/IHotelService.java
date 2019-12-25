package cn.wolfcode.luowowo.hotel.service;

import cn.wolfcode.luowowo.hotel.domain.Hotel;

import java.util.List;

public interface IHotelService {
    /**
     * 根据目的地id,查询有价格优惠的前8个酒店
     * @param destId
     * @return
     */
    List<Hotel> querySpecialOfferHotelByDestIdTop8(Long destId);
}
