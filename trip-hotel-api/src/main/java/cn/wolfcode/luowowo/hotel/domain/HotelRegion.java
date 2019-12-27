package cn.wolfcode.luowowo.hotel.domain;

import cn.wolfcode.luowowo.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class HotelRegion extends BaseDomain{
    private String name;
    private Long destId;
    private String info;
    private Long hotelNum;
    private Long hotScore;
    private BigDecimal avgPrice;
}