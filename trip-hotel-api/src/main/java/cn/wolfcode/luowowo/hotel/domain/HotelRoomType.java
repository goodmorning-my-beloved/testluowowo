package cn.wolfcode.luowowo.hotel.domain;

import cn.wolfcode.luowowo.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
public class HotelRoomType extends BaseDomain{
    private Long hotelId;   // 酒店
    private String roomType;
    private Long totalRoomNum;
    private BigDecimal roomPrice;
    private Long maxLiveNum;
    private Boolean specialOffer;
    private Object tool;

}