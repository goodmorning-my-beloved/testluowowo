package cn.wolfcode.luowowo.article.service.impl;

import cn.wolfcode.luowowo.article.domain.AirTicketOrder;
import cn.wolfcode.luowowo.article.mapper.AirTicketOrderMapper;
import cn.wolfcode.luowowo.article.service.IAirTicketOrderService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AirTicketOrderServiceImpl implements IAirTicketOrderService {

    @Autowired
    private AirTicketOrderMapper airTicketOrderMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return airTicketOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AirTicketOrder record) {
        return airTicketOrderMapper.insert(record);
    }

    @Override
    public AirTicketOrder selectByPrimaryKey(Long id) {
        return airTicketOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AirTicketOrder> selectAll() {
        return airTicketOrderMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(AirTicketOrder record) {
        return 0;
    }

    @Override
    public List<AirTicketOrder> selectByUserId(Long id) {

        return airTicketOrderMapper.selectById(id);
    }
}
