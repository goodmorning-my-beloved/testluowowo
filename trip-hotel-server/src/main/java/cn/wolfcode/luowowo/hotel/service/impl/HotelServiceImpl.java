package cn.wolfcode.luowowo.hotel.service.impl;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.hotel.domain.Hotel;
import cn.wolfcode.luowowo.hotel.mapper.HotelMapper;
import cn.wolfcode.luowowo.hotel.query.HotelQuery;
import cn.wolfcode.luowowo.hotel.service.IHotelService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService {
    @Autowired
    private HotelMapper hotelMapper;
    @Reference
    private IDestinationService destinationService;
    @Override
    public List<Hotel> querySpecialOfferHotelByDestIdTop8(Long destId) {
        return hotelMapper.selectSpecialOfferHotelByDestIdTop8(destId);
    }

    /**
     * 根据目的地位置,查询当地酒店
     * @param qo
     * @return
     */
    @Override
    public PageInfo queryHotelByCityNameAndSoOn(HotelQuery qo) {
        Destination destination = null;
        if(qo.getName() != null){
            destination = destinationService.getByDestName(qo.getName());
        }
        qo.setDestId(destination.getId());
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        return new PageInfo(hotelMapper.selectByDestId(qo));
    }
}
