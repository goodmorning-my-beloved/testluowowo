package cn.wolfcode.luowowo.article.service;

import cn.wolfcode.luowowo.article.domain.AirTicket;

import java.util.Date;
import java.util.List;

public interface IAirTicketService {
    /**
     * 查询热门的航班出发地
     * @return
     */
    List<AirTicket> getStartSiteByIshot(String[] arr);

    /**
     * 查询航班信息
     * @param orgCity 出发机场三字码
     * @param dstCity 到达机场三字码
     * @param deptTime 到达时间
     * @return
     */
    List<AirTicket> search(String orgCity, String dstCity, String depTime);

    /**
     * 根据id查询航班信息
     * @param id
     * @return
     */
    AirTicket selectById(int id);

   /* List<AirTicket> selectByIds(List<Long> ids);*/
}
