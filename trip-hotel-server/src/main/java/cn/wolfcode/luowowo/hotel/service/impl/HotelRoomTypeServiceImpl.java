package cn.wolfcode.luowowo.hotel.service.impl;

import cn.wolfcode.luowowo.hotel.domain.HotelRoomType;
import cn.wolfcode.luowowo.hotel.mapper.HotelRoomTypeMapper;
import cn.wolfcode.luowowo.hotel.service.IHotelRoomTypeService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class HotelRoomTypeServiceImpl implements IHotelRoomTypeService {
    @Autowired
    private HotelRoomTypeMapper hotelRoomTypeMapper;

    /**
     * 根据酒店的id,查出酒店有什么类型的房间
     * @param hotelId
     * @return
     */
    @Override
    public List<HotelRoomType> queryHotelRoomTypeByHotelId(Long hotelId) {
        return hotelRoomTypeMapper.selectByHotelId(hotelId);
    }

    @Override
    public HotelRoomType getHotelRoomTypeById(Long hotelRoomTypeId) {
        return hotelRoomTypeMapper.selectByPrimaryKey(hotelRoomTypeId);
    }
}
