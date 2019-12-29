package cn.wolfcode.luowowo.hotel.service.impl;

import cn.wolfcode.luowowo.common.exception.LogicException;
import cn.wolfcode.luowowo.hotel.domain.HotelRoomOrder;
import cn.wolfcode.luowowo.hotel.domain.HotelRoomType;
import cn.wolfcode.luowowo.hotel.mapper.HotelRoomOrderMapper;
import cn.wolfcode.luowowo.hotel.query.HotelQuery;
import cn.wolfcode.luowowo.hotel.service.IHotelRoomOrderService;
import cn.wolfcode.luowowo.hotel.service.IHotelRoomTypeService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class HotelRoomOrderServiceImpl implements IHotelRoomOrderService{
    @Autowired
    private HotelRoomOrderMapper hotelRoomOrderMapper;

    @Override
    public List<HotelRoomOrder> queryHotelRoomOrderByHotelRoomTypeId(Long hotelTypeId) {
        return hotelRoomOrderMapper.selectEffectiveByHotelRoomTypeId(hotelTypeId);
    }

    /**
     * 查询在用户输入的时间范围内,酒店的每个房型是否已售罄,
     * @param qo
     * @param hotelRoomType
     * @return true 代表房型没有售罄,false代表房型售罄
     */
    @Override
    public Boolean checkSoldOut(HotelQuery qo, HotelRoomType hotelRoomType) {
        Long totalRoomNum = hotelRoomType.getTotalRoomNum();
        List<HotelRoomOrder> hotelOrderList = this.queryHotelRoomOrderByHotelRoomTypeId(hotelRoomType.getId());
        Date checkOut = qo.getCheckOut();
        Date checkIn = qo.getCheckIn();
        if(checkOut ==null&& checkIn ==null){
            return true;   // 如果没有输入订房时间,那么不查询是否售罄
        }
        for (HotelRoomOrder hotelRoomOrder : hotelOrderList) {
//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            long checkInTime = checkIn.getTime();
            long checkOutTime = checkOut.getTime();
            long orderCheckIn = hotelRoomOrder.getCheckIn().getTime();
            long orderCheckOut = hotelRoomOrder.getCheckOut().getTime();
            if((orderCheckIn<checkInTime & checkInTime<orderCheckOut)||(orderCheckIn<checkOutTime & checkOutTime<orderCheckOut)){
                totalRoomNum=totalRoomNum-1;
            }
        }
        if(totalRoomNum==0){   // 代表售罄
            return false;
        }
        return true;
    }

    @Override
    public void save(HotelRoomOrder hotelRoomOrder) throws LogicException{
        if(hotelRoomOrder.getCheckIn()==null||hotelRoomOrder.getCheckOut()==null){
            throw new LogicException("请在搜索栏输入预订入住时间,再重新提交订单");
        }
        if(hotelRoomOrder.getCheckOut().getTime()-hotelRoomOrder.getCheckIn().getTime()<0){
            throw new LogicException("劳烦退房时间不要早于订房时间");
        }
        hotelRoomOrderMapper.insert(hotelRoomOrder);
    }

    @Override
    public List<HotelRoomOrder> queryHotelOrderByUserId(Long userId) {
       return  hotelRoomOrderMapper.selectByUserId(userId);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        hotelRoomOrderMapper.deleteByPrimaryKey(id);
    }
}
