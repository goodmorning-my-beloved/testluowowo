package cn.wolfcode.luowowo.article.domain;

import cn.wolfcode.luowowo.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter@ToString
public class AirTicket extends BaseDomain {

    // 航班号
    private String aircode;

    // 关联出发城市/机场
    private AirCity startCity;

    //出发日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    //出发时间
    private String startTime;

    // 关联到达城市/机场
    private AirCity arriveCity;

    //到达日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arriveDate;

    //到达时间
    private String arriveTime;

    //航班机型
    private String planeType;

    //是否热门
    private Boolean ishot;

}