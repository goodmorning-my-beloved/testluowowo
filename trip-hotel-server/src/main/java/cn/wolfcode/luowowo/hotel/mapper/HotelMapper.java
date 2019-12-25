package cn.wolfcode.luowowo.hotel.mapper;

import cn.wolfcode.luowowo.hotel.domain.Hotel;
import java.util.List;

public interface HotelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Hotel record);

    Hotel selectByPrimaryKey(Long id);

    List<Hotel> selectAll();

    int updateByPrimaryKey(Hotel record);

    List<Hotel> selectSpecialOfferHotelByDestIdTop8(Long destId);
}