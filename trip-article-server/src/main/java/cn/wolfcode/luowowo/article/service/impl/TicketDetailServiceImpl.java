package cn.wolfcode.luowowo.article.service.impl;

import cn.wolfcode.luowowo.article.domain.TicketDetail;
import cn.wolfcode.luowowo.article.mapper.TicketDetailMapper;
import cn.wolfcode.luowowo.article.service.ITicketDetailService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by acer on 2019/12/27.
 */
@Service
public class TicketDetailServiceImpl implements ITicketDetailService {

    @Autowired
    private TicketDetailMapper ticketDetailMapper;
    @Override
    public int insert(TicketDetail record) {
        return ticketDetailMapper.insert(record);
    }

    @Override
    public List<TicketDetail> selectAll() {
        return ticketDetailMapper.selectAll();
    }

    @Override
    public TicketDetail selectById(Long tid) {
        return ticketDetailMapper.selectById(tid);
    }
}
