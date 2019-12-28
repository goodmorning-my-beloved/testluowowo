package cn.wolfcode.luowowo.hotel.query;

import cn.wolfcode.luowowo.common.query.QueryObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class HotelQuery extends HotelQueryObject{
    private String name;  // 酒店所在地名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date checkIn;   // 入住时间
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkOut;  // 退房时间
    private Long destId;   // 酒店所在地id
    private String orderType;   // 排序规则,默认按照分数降序
    private String orderBy="score desc";  // 排序规则,默认按照分数降序
    private Long haveRoom = -1L;  // 默认仅查询有房
    private Long hotelThemeId = -1L;  // 默认查询全部主题的酒店
    private BigDecimal minPrice ;
    private BigDecimal maxPrice ;  // 查询的价格范围
    private Long hotelRegion = -1L;  // 酒店所在地的区域
    public String getOrderBy(){
        if("hot".equals(orderType)){
            return "sales desc";   //销量
        }else if("price".equals(orderType)){
            return "price";  // 价格升序
        }
        return "score desc" ;  // 排序规则,默认按照分数降序
    }
}