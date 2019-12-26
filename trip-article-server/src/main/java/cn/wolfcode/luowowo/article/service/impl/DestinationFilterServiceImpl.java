package cn.wolfcode.luowowo.article.service.impl;

import cn.wolfcode.luowowo.article.domain.DestinationCommendTheme;
import cn.wolfcode.luowowo.article.domain.DestinationFilter;
import cn.wolfcode.luowowo.article.mapper.DestinationFilterMapper;
import cn.wolfcode.luowowo.article.query.DestinationFilterQuery;
import cn.wolfcode.luowowo.article.service.IDestinationFilterService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DestinationFilterServiceImpl implements IDestinationFilterService {

    @Autowired
    private DestinationFilterMapper destinationFilterMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return destinationFilterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DestinationFilter record) {

        return destinationFilterMapper.insert(record);
    }

    @Override
    public DestinationFilter selectByPrimaryKey(Long id) {
        return destinationFilterMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DestinationFilter> selectAll() {
        return destinationFilterMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(DestinationFilter record) {
        return destinationFilterMapper.updateByPrimaryKey(record);
    }
    //根据主题ti查询目的地推荐
    @Override
    public List<DestinationFilter> selectByThemeId(Long themeId) {
        return destinationFilterMapper.selectByThemeId(themeId);
    }

    @Override
    public PageInfo<DestinationFilter> query(DestinationFilterQuery qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        return new PageInfo(destinationFilterMapper.selectForList(qo));
    }
}
