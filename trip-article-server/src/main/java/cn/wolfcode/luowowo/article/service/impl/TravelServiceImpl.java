package cn.wolfcode.luowowo.article.service.impl;

import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.domain.TravelContent;
import cn.wolfcode.luowowo.article.mapper.TravelContentMapper;
import cn.wolfcode.luowowo.article.mapper.TravelMapper;
import cn.wolfcode.luowowo.article.query.TravelQuery;
import cn.wolfcode.luowowo.article.service.ITravelService;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class TravelServiceImpl implements ITravelService {

    @Autowired
    private TravelMapper travelMapper;
    @Autowired
    private TravelContentMapper travelContentMapper;
    @Override
    public PageInfo queryForList(TravelQuery qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        return new PageInfo(travelMapper.list(qo));
    }

    @Override
    public PageInfo queryForListByDestId(TravelQuery qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        return new PageInfo(travelMapper.selectByDestId(qo));

    }

    @Override
    public Long saveOrUpdate(Travel travel) {
        //摘要处理
        String content = travel.getTravelContent().getContent();
        if(content.length()>200){
            travel.setSummary(content.substring(0,200));
        }else{
            travel.setSummary(content);
        }
        //最后更新时间
        travel.setLastUpdateTime(new Date());
        TravelContent travelContent=new TravelContent();

        if(travel.getId()==null){
            //创建时间
            travel.setCreateTime(new Date());
            travelMapper.insert(travel);
            //内容表
            travelContent.setId(travel.getId());
            travelContent.setContent(travel.getTravelContent().getContent());
            travelContentMapper.insert(travelContent);
        }else {
            travelMapper.updateByPrimaryKey(travel);
            //内容表
            travelContent.setId(travel.getId());
            travelContent.setContent(travel.getTravelContent().getContent());
            travelContentMapper.update(travelContent);
        }
        return travel.getId();
    }

    @Override
    public Travel selectById(Long id) {
        return travelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Travel> queryTravelTop3ByDestId(Long destId) {
        return travelMapper.selectTravelTop3ByDestId(destId);

    }

    @Override
    public PageInfo query(TravelQuery qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize(), qo.getOrderBy());
        return new PageInfo(travelMapper.selectForList(qo));
    }

    @Override
    public UserInfo getAuthorById(Long id) {

        return travelMapper.selectAuthorById(id);
    }

    @Override
    public List<Travel> list() {
        return travelMapper.selectAll();
    }
}
