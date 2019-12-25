package cn.wolfcode.luowowo.article.service.impl;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.domain.Region;
import cn.wolfcode.luowowo.article.mapper.RegionMapper;
import cn.wolfcode.luowowo.article.query.RegionQuery;
import cn.wolfcode.luowowo.article.service.IRegionService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public PageInfo query(RegionQuery qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        return new PageInfo(regionMapper.selectForList(qo));
    }

    @Override
    public void saveOrUpdate(Region region) {

        if(region.getId() == null){
            regionMapper.insert(region);
        }else{
            regionMapper.updateByPrimaryKey(region);
        }
    }

    @Override
    public Region get(Long rid) {
        return regionMapper.selectByPrimaryKey(rid);
    }

    @Override
    public List<Region> queryHotRegions() {
        return regionMapper.selectHotRegions();
    }

    @Override
    public void changeHotById(Long id, int hot) {
        regionMapper.updateHotById(id,hot);
    }

    @Override
    public void deleteById(Long id) {
        regionMapper.deleteByPrimaryKey(id);
    }



}
