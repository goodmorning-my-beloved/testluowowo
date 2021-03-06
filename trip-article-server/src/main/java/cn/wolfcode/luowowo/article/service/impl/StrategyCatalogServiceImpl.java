package cn.wolfcode.luowowo.article.service.impl;

import cn.wolfcode.luowowo.article.domain.StrategyCatalog;
import cn.wolfcode.luowowo.article.mapper.StrategyCatalogMapper;
import cn.wolfcode.luowowo.article.query.StrategyCatalogQuery;
import cn.wolfcode.luowowo.article.service.IStrategyCatalogService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StrategyCatalogServiceImpl implements IStrategyCatalogService {

    @Autowired
    private StrategyCatalogMapper strategyCatalogMapper;

    @Override
    public PageInfo query(StrategyCatalogQuery qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        return new PageInfo(strategyCatalogMapper.selectForList(qo));
    }

    @Override
    public void saveOrUpdate(StrategyCatalog strategyCatalog) {
        if(strategyCatalog.getId() == null){
            strategyCatalogMapper.insert(strategyCatalog);
        }else{
            strategyCatalogMapper.updateByPrimaryKey(strategyCatalog);
        }
    }

    @Override
    public StrategyCatalog get(Long id) {
        return strategyCatalogMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        strategyCatalogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<StrategyCatalog> selectCatalogByStrategyId(Long strategyId) {
        return strategyCatalogMapper.selectCatalogByStrategyId(strategyId);
    }

    @Override
    public List<StrategyCatalog> selectCatalogByDestId(Long id) {
        return strategyCatalogMapper.selectCatalogByDestId(id);
    }
}
