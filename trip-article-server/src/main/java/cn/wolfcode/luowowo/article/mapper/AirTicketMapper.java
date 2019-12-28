package cn.wolfcode.luowowo.article.mapper;

import cn.wolfcode.luowowo.article.domain.AirTicket;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AirTicketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AirTicket record);

    AirTicket selectByPrimaryKey(Integer id);

    List<AirTicket> selectAll();

    int updateByPrimaryKey(AirTicket record);

    List<AirTicket> selectStartSiteByIshot();

    List<AirTicket> search(@Param("orgCity") String orgCity, @Param("dstCity") String dstCity, @Param("depTime") String depTime);
    //订购查询
    AirTicket selectById(int id);

   /* List<AirTicket> selectByIds(List<Long> ids);*/
}