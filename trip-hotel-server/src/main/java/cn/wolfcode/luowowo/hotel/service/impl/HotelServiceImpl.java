package cn.wolfcode.luowowo.hotel.service.impl;

import cn.wolfcode.luowowo.hotel.domain.Hotel;
import cn.wolfcode.luowowo.hotel.mapper.HotelMapper;
import cn.wolfcode.luowowo.hotel.service.IHotelService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService {
    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public List<Hotel> querySpecialOfferHotelByDestIdTop8(Long destId) {
        return hotelMapper.selectSpecialOfferHotelByDestIdTop8(destId);
    }
}
