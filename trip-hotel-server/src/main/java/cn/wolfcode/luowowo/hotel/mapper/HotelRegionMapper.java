package cn.wolfcode.luowowo.hotel.mapper;

import cn.wolfcode.luowowo.hotel.domain.HotelRegion;
import java.util.List;

public interface HotelRegionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelRegion record);

    HotelRegion selectByPrimaryKey(Long id);

    List<HotelRegion> selectAll();

    int updateByPrimaryKey(HotelRegion record);

    List<HotelRegion> selectByDestId(Long destId);
}