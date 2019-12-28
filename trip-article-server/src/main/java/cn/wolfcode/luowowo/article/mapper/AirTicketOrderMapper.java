package cn.wolfcode.luowowo.article.mapper;

import cn.wolfcode.luowowo.article.domain.AirTicketOrder;
import java.util.List;

public interface AirTicketOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AirTicketOrder record);

    AirTicketOrder selectByPrimaryKey(Long id);

    List<AirTicketOrder> selectAll();

    List<AirTicketOrder> selectById(Long id);

    int updateByPrimaryKey(AirTicketOrder record);

}