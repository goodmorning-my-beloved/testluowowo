package cn.wolfcode.luowowo.article.service.impl;

import cn.wolfcode.luowowo.article.domain.TicketOrder;
import cn.wolfcode.luowowo.article.mapper.TicketOrderMapper;
import cn.wolfcode.luowowo.article.service.ITicketOrderService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by acer on 2019/12/27.
 */
@Service
public class TicketOrderServiceImpl implements ITicketOrderService {

    @Autowired
    private TicketOrderMapper ticketOrderMapper;
    @Override
    public int insert(TicketOrder record) {
        record.setCreatime(new Date());
        return ticketOrderMapper.insert(record);
    }

    @Override
    public List<TicketOrder> selectAll() {
        return ticketOrderMapper.selectAll();
    }

    @Override
    public TicketOrder selectById(Long tid) {
        return ticketOrderMapper.selectByPrimaryKey(tid);
    }

    @Override
    public List<TicketOrder> selectByUserId(long id) {

        return ticketOrderMapper.selectByUserId(id);
    }

    @Override
    public void deleteById(Long id) {
        ticketOrderMapper.deleteByPrimaryKey(id);
    }
}
