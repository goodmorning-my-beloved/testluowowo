package cn.wolfcode.luowowo.article.service;

import cn.wolfcode.luowowo.article.domain.TicketOrder;

import java.util.List;

/**
 * Created by acer on 2019/12/27.
 */
public interface ITicketOrderService {
    int insert(TicketOrder record);

    List<TicketOrder> selectAll();

    TicketOrder selectById(Long tid);

    List<TicketOrder> selectByUserId(long id);

    void deleteById(Long id);
}
