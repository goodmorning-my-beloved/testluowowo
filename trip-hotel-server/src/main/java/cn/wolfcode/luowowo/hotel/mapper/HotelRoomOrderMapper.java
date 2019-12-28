package cn.wolfcode.luowowo.hotel.mapper;

import cn.wolfcode.luowowo.hotel.domain.HotelRoomOrder;
import java.util.List;

public interface HotelRoomOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelRoomOrder record);

    HotelRoomOrder selectByPrimaryKey(Long id);

    List<HotelRoomOrder> selectAll();

    int updateByPrimaryKey(HotelRoomOrder record);

    List<HotelRoomOrder> selectEffectiveByHotelRoomTypeId(Long hotelTypeId);

    List<HotelRoomOrder> selectByUserId(Long userId);
}