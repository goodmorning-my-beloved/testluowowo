package cn.wolfcode.luowowo.scenic.service.impl;

import cn.woldcode.luowowo.scenic.domain.Scenic;
import cn.woldcode.luowowo.scenic.service.IScenicService;
import cn.wolfcode.luowowo.scenic.mapper.ScenicMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ScenicServiceImpl implements IScenicService{

    @Autowired
    private ScenicMapper scenicMapper;

    @Override
    public List<Scenic> queryScenicTop5() {
        return scenicMapper.selectScenicTop5();
    }

    @Override
    public List<Scenic> queryHotScenics() {
        return scenicMapper.selectHotScenics();
    }
}