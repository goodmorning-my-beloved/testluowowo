package cn.wolfcode.luowowo.article.service;

import cn.wolfcode.luowowo.article.domain.TicketDetail;

import java.util.List;

/**
 * Created by acer on 2019/12/27.
 */
public interface ITicketDetailService {
    int insert(TicketDetail record);

    List<TicketDetail> selectAll();

    TicketDetail selectById(Long tid);
}
