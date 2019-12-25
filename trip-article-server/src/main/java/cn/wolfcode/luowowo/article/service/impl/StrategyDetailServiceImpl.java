package cn.wolfcode.luowowo.article.service.impl;

import cn.wolfcode.luowowo.article.domain.Strategy;
import cn.wolfcode.luowowo.article.domain.StrategyContent;
import cn.wolfcode.luowowo.article.domain.StrategyDetail;
import cn.wolfcode.luowowo.article.domain.StrategyTag;
import cn.wolfcode.luowowo.article.mapper.StrategyContentMapper;
import cn.wolfcode.luowowo.article.mapper.StrategyDetailMapper;
import cn.wolfcode.luowowo.article.mapper.StrategyTagMapper;
import cn.wolfcode.luowowo.article.query.StrategyDetailQuery;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.article.service.IStrategyDetailService;
import cn.wolfcode.luowowo.article.service.IStrategyService;
import cn.wolfcode.luowowo.article.service.IStrategyTagService;
import cn.wolfcode.luowowo.article.vo.StrategyStatisPersistenceVO;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class StrategyDetailServiceImpl implements IStrategyDetailService {

    @Autowired
    private StrategyDetailMapper strategyDetailMapper;

    @Autowired
    private StrategyContentMapper strategyContentMapper;

    @Autowired
    private IStrategyService strategyService;

    @Autowired
    private IDestinationService destinationService;

    @Autowired
    private IStrategyTagService strategyTagService;

    @Autowired
    private StrategyTagMapper strategyTagMapper;

    @Override
    public PageInfo query(StrategyDetailQuery qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        return new PageInfo(strategyDetailMapper.selectForList(qo));
    }
    @Override
    public List<StrategyDetail> list() {
        return strategyDetailMapper.selectAll();
    }

    @Override
    public StrategyDetail get(Long id) {
        return strategyDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(StrategyDetail detail, String tags) {
        //应该先把需要的数据补齐
        //目的地,哪里来?传过来的攻略对应的能查到目的地
        Strategy dest=strategyService.get(detail.getStrategy().getId());
        detail.setDest(dest.getDest());
        //作者先不用
        //内容摘要,从内容里面截200个字符串作为内容摘要
        String content = detail.getStrategyContent().getContent();
        if(content.length() > 200){
            detail.setSummary(content.substring(0, 200));
        }else{
            detail.setSummary(content);
        }
        //是否是国外,判断顶级是不是中国就行,面包屑
        detail.setIsabroad(destinationService.getToasts(dest.getId()).get(0).getId()!=1);
        //-------------------------------------------------
        String[] names = tags.split(",");
        StrategyTag strategyTag=new StrategyTag();
        if(detail.getId()==null){
            //创建时间
            detail.setCreateTime(new Date());
            strategyDetailMapper.insert(detail);
            //加内容
            StrategyContent strategyContent = detail.getStrategyContent();
            strategyContent.setId(detail.getId());
            strategyContentMapper.insert(strategyContent);
            //攻略标签的处理,攻略标签跟攻略文章中间表的维护
            for (String name : names) {
                strategyTag.setName(name);
                strategyTagMapper.insert(strategyTag);
                //维护中间表
                strategyDetailMapper.insertRelation(detail.getId(),strategyTag.getId());
            }
        }else{
            strategyDetailMapper.updateByPrimaryKey(detail);
            //修改内容表
            StrategyContent strategyContent = detail.getStrategyContent();
            strategyContent.setId(detail.getId());
            strategyContentMapper.updateByPrimaryKey(strategyContent);
            //攻略标签的处理,攻略标签跟攻略文章中间表的维护
            //先删除之前的中间表关系,再添加
            strategyDetailMapper.deleteRelationByDetailId(detail.getId());
            for (String name : names) {
                strategyTag.setName(name);
                strategyTagMapper.insert(strategyTag);
                strategyTag.setName(name);
                //维护中间表
                strategyDetailMapper.insertRelation(detail.getId(),strategyTag.getId());
            }
        }
    }

    @Override
    public StrategyContent getContent(Long id) {
        return strategyContentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void changeState(Long state, Long id) {
        strategyDetailMapper.updateState(state,id);
    }

    @Override
    public void delete(Long id) {
        strategyDetailMapper.deleteByPrimaryKey(id);

    }

    @Override
    public List<StrategyDetail> queryDetailsTop3ByDestId(Long destId) {

        return strategyDetailMapper.selectByDetailsTop3ByDestId(destId);
    }

    @Override
    public PageInfo listByDestId(StrategyDetailQuery qo) {

        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        return new PageInfo(strategyDetailMapper.selsectListByDestId(qo));
    }

    @Override
    public void updateStatis(StrategyStatisPersistenceVO pvo) {
        strategyDetailMapper.updateStatis(pvo);
    }
}
