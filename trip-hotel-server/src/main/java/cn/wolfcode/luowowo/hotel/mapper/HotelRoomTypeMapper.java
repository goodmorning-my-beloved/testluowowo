package cn.wolfcode.luowowo.hotel.mapper;

import cn.wolfcode.luowowo.hotel.domain.HotelRoomType;
import java.util.List;

public interface HotelRoomTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelRoomType record);

    HotelRoomType selectByPrimaryKey(Long id);

    List<HotelRoomType> selectAll();

    int updateByPrimaryKey(HotelRoomType record);


    List<HotelRoomType> selectByHotelId(Long hotelId);
}