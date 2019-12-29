package cn.wolfcode.luowowo.article.service.impl;

import cn.wolfcode.luowowo.article.domain.AttractionTicket;
import cn.wolfcode.luowowo.article.mapper.AttractionTicketMapper;
import cn.wolfcode.luowowo.article.service.IAttractionTicketService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by acer on 2019/12/27.
 * 门票
 */
@Service
public class AttractionTicketServiceImpl implements IAttractionTicketService {

    @Autowired
    private AttractionTicketMapper attractionTicketMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        attractionTicketMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int insert(AttractionTicket record) {
        attractionTicketMapper.insert(record);
        return 0;
    }

    @Override
    public AttractionTicket selectByPrimaryKey(Long id) {
        return attractionTicketMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AttractionTicket> selectAll() {
        return attractionTicketMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(AttractionTicket record) {
        return attractionTicketMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<AttractionTicket> selectByDestId(Long ajaxDestId) {
        return attractionTicketMapper.selectByDestId(ajaxDestId);
    }

}
