package cn.wolfcode.luowowo.article.service;

import cn.wolfcode.luowowo.article.domain.AttractionTicket;

import java.util.List;

/**
 * Created by acer on 2019/12/27.
 */
public interface IAttractionTicketService {
    int deleteByPrimaryKey(Long id);

    int insert(AttractionTicket record);

    AttractionTicket selectByPrimaryKey(Long id);

    List<AttractionTicket> selectAll();

    int updateByPrimaryKey(AttractionTicket record);

    List<AttractionTicket> selectByDestId(Long ajaxDestId);
}
