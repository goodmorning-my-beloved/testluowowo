package cn.wolfcode.luowowo.article.mapper;

import cn.wolfcode.luowowo.article.domain.AttractionTicket;
import java.util.List;

public interface AttractionTicketMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AttractionTicket record);

    AttractionTicket selectByPrimaryKey(Long id);

    List<AttractionTicket> selectAll();
    List<AttractionTicket> selectByDestId(Long destId);
    int updateByPrimaryKey(AttractionTicket record);


}