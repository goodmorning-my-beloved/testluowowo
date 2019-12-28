package cn.wolfcode.luowowo.hotel.domain;

import cn.wolfcode.luowowo.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Hotel extends BaseDomain{

    private String name;
    private String english;
    private String coverUrl;
    private Long destId;   // 目的地
    private BigDecimal score;
    private String url;
    private BigDecimal price;
    private String address;
    private Long hotelThemeId;  // 酒店主题
    private Long haveRoom;
    private Long sales;
    private Long hotelRegionId;  //酒店所属区域
    private Object tool;
}