package cn.wolfcode.luowowo.scenic.service.impl;

import cn.woldcode.luowowo.scenic.domain.Scenic;
import cn.woldcode.luowowo.scenic.query.ScenicQuery;
import cn.woldcode.luowowo.scenic.service.IScenicService;
import cn.wolfcode.luowowo.comment.domain.ScenicComment;
import cn.wolfcode.luowowo.scenic.mapper.ScenicMapper;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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

    @Override
    public PageInfo page(ScenicQuery qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        List<Scenic> scenics = scenicMapper.selectForList(qo);
        return new PageInfo(scenics);
    }

    @Override
    public Scenic queryScenicById(Long id) {
        return scenicMapper.selectScenicById(id);
    }

    @Override
    public List<Scenic> queryScenicByParentId(Long parentId) {
        return scenicMapper.selectByParentId(parentId);
    }


}
