package cn.wolfcode.luowowo.hotel.service.impl;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.hotel.domain.Hotel;
import cn.wolfcode.luowowo.hotel.domain.HotelRoomOrder;
import cn.wolfcode.luowowo.hotel.domain.HotelRoomType;
import cn.wolfcode.luowowo.hotel.mapper.HotelMapper;
import cn.wolfcode.luowowo.hotel.query.HotelQuery;
import cn.wolfcode.luowowo.hotel.service.IHotelRoomOrderService;
import cn.wolfcode.luowowo.hotel.service.IHotelRoomTypeService;
import cn.wolfcode.luowowo.hotel.service.IHotelService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService {
    @Autowired
    private HotelMapper hotelMapper;
    @Reference
    private IDestinationService destinationService;
    @Reference
    private IHotelRoomTypeService hotelRoomTypeService;
    @Reference
    private IHotelRoomOrderService hotelRoomOrderService;

    @Override
    public List<Hotel> querySpecialOfferHotelByDestIdTop8(Long destId) {
        return hotelMapper.selectSpecialOfferHotelByDestIdTop8(destId);
    }

    /**
     * 根据目的地位置,查询当地酒店,可能需要校验时间
     * @param qo
     * @return
     */
    @Override
    public PageInfo queryHotelByCityNameAndSoOn(HotelQuery qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize(),qo.getOrderBy());
        List<Hotel> hotels = hotelMapper.selectByDestId(qo);
        // 进行处理
        Date checkIn = qo.getCheckIn();
        Date checkOut = qo.getCheckOut();
        if(checkIn !=null|| checkOut !=null){
            ArrayList<Object> list = new ArrayList<>();
            for (Hotel hotel : hotels) {
                int flag = 0;
                List<HotelRoomType> hotelTypeList = hotelRoomTypeService.queryHotelRoomTypeByHotelId(hotel.getId());
                for (HotelRoomType hotelRoomType : hotelTypeList) {
                    Long totalRoomNum = hotelRoomType.getTotalRoomNum();
                    List<HotelRoomOrder> hotelOrderList = hotelRoomOrderService.queryHotelRoomOrderByHotelRoomTypeId(hotelRoomType.getId());
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
                    if(totalRoomNum>0){
                        flag = 1;
                    }
                }
                if(flag==0){
                    hotels.remove(hotel);
                }
                // 长度
            }
            return new PageInfo(hotels);
        }
        return new PageInfo(hotels);
    }

    /**
     * 根据酒店id,查询酒店
     * @param id
     * @return
     */
    @Override
    public Hotel getHotelInfoByPrimaryKey(Long id) {
        return  hotelMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<Hotel> queryHotelDeatilInfomationByUserId(Long userId) {
        List<Object> list = new ArrayList<>();
        List<HotelRoomOrder> orders = hotelRoomOrderService.queryHotelOrderByUserId(userId);
        for (HotelRoomOrder order : orders) {
            HotelRoomType hotelRoomType = hotelRoomTypeService.getHotelRoomTypeById(order.getHotelRoomTypeId());
            Long hotelId = hotelRoomType.getHotelId();
            list.add(hotelId);

        }
        return null;
    }
}
