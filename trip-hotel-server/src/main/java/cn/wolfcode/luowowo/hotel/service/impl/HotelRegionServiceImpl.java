package cn.wolfcode.luowowo.hotel.service.impl;

import cn.wolfcode.luowowo.hotel.domain.HotelRegion;
import cn.wolfcode.luowowo.hotel.mapper.HotelRegionMapper;
import cn.wolfcode.luowowo.hotel.service.IHotelRegionService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class HotelRegionServiceImpl implements IHotelRegionService{
    @Autowired
    private HotelRegionMapper hotelRegionMapper;


    @Override
    public List<HotelRegion> queryAllHotelRegionByDestId(Long destId) {
     return hotelRegionMapper.selectByDestId(destId);
    }

    @Override
    public HotelRegion getByPrimaryId(Long id) {
     return hotelRegionMapper.selectByPrimaryKey(id);
    }
}
