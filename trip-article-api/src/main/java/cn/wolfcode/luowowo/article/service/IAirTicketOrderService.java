package cn.wolfcode.luowowo.article.service;

import cn.wolfcode.luowowo.article.domain.AirTicketOrder;

import java.util.List;

public interface IAirTicketOrderService {
    int deleteByPrimaryKey(Long id);

    int insert(AirTicketOrder record);

    AirTicketOrder selectByPrimaryKey(Long id);

    List<AirTicketOrder> selectAll();

    int updateByPrimaryKey(AirTicketOrder record);
    //查询航班订单
    List<AirTicketOrder> selectByUserId(Long id);
}
