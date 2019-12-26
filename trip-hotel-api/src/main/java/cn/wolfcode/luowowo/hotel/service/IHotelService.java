package cn.wolfcode.luowowo.hotel.service;

import cn.wolfcode.luowowo.hotel.domain.Hotel;
import cn.wolfcode.luowowo.hotel.query.HotelQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IHotelService {
    /**
     * 根据目的地id,查询有价格优惠的前8个酒店
     * @param destId
     * @return
     */
    List<Hotel> querySpecialOfferHotelByDestIdTop8(Long destId);

    /**
     * 根据 酒店所在地等信息查询酒店
     * @param qo
     * @return
     */
    PageInfo queryHotelByCityNameAndSoOn(HotelQuery qo);
}


