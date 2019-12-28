package cn.wolfcode.luowowo.article.mapper;

import cn.wolfcode.luowowo.article.domain.TicketOrder;
import java.util.List;

public interface TicketOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TicketOrder record);

    TicketOrder selectByPrimaryKey(Long id);

    List<TicketOrder> selectAll();

    int updateByPrimaryKey(TicketOrder record);

    List<TicketOrder> selectByUserId(long id);
}