package cn.wolfcode.luowowo.article.mapper;

import cn.wolfcode.luowowo.article.domain.TicketDetail;
import java.util.List;

public interface TicketDetailMapper {
    int insert(TicketDetail record);
    TicketDetail selectById(Long tid);
    List<TicketDetail> selectAll();
}