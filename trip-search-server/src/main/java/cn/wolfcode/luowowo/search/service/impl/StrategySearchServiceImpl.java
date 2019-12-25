package cn.wolfcode.luowowo.search.service.impl;

import cn.wolfcode.luowowo.search.domain.StrategyTemplate;
import cn.wolfcode.luowowo.search.query.SearchQueryObject;
import cn.wolfcode.luowowo.search.repository.StrategyTemplateRepository;
import cn.wolfcode.luowowo.search.service.IStrategySearchService;
import cn.wolfcode.luowowo.search.vo.StatisVO;
import com.alibaba.dubbo.config.annotation.Service;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.aggregations.bucket.composite.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.util.*;

@Service
public class StrategySearchServiceImpl implements IStrategySearchService {

    //es 依然使用spring-data-jpa

    //repository 封装了template
    //template 封装了 client

    @Autowired
    private StrategyTemplateRepository repository;
    @Autowired
    private ElasticsearchTemplate template;

    @Override
    public void saveOrUpdate(StrategyTemplate strategyTemplate) {
        repository.save(strategyTemplate);
    }

    @Override
    public List<Map<String, Object>> queryThemeTop10() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = null;
        List<StatisVO> vos = statisVOGroup("themeId", "themeName", "themeGroup", null);
        for (StatisVO statisVO : vos) {
            //目的地列表: 通过主题id查目的集合
            List<StatisVO> dests = queryDestsByThemeId(statisVO.getId());
            map = new HashMap<>();
            map.put("theme", statisVO);
            map.put("dests", dests);
            list.add(map);
        }
        //3:只需要前10个
        if (list.size() > 10) {
            list = list.subList(0, 10);
        }
        return list;
    }

    @Override
    public List<StatisVO> queryConditionThemeGroup() {
        return statisVOGroup("themeId", "themeName", "themeGroup", null);
    }

    @Override
    public List<StatisVO> queryConditionProvincesGroup() {
        return  statisVOGroup("provinceId","provinceName", "provinceGroup", null );
    }

    @Override
    public List<StatisVO> queryConditionAbroadsGroup() {
        BoolQueryBuilder query = QueryBuilders.boolQuery()
                .mustNot(QueryBuilders.termQuery("countryId", 1));
        return  statisVOGroup("countryId","countryName", "countryGroup",query);
    }

    @Override
    public Page query(SearchQueryObject qo) {
        Pageable pageable = PageRequest.of(qo.getCurrentPage()-1, qo.getPageSize(),
                Sort.Direction.DESC, qo.getOrderBy());

        TermQueryBuilder builder = null;
        //主题:
        if(qo.getType() == SearchQueryObject.CONDITION_TYPE_THEME){
            builder = QueryBuilders.termQuery("themeId", qo.getTypeValue());
        }else  if(qo.getType() == SearchQueryObject.CONDITION_TYPE_ABROAD){
            //国家
            builder = QueryBuilders.termQuery("countryId", qo.getTypeValue());
        }else if(qo.getType() == SearchQueryObject.CONDITION_TYPE_CHINA){
            //省份
            builder = QueryBuilders.termQuery("provinceId", qo.getTypeValue());
        }

        if(builder != null){
            return repository.search(builder, pageable);
        }
        return repository.findAll(pageable) ;
    }

    @Override
    public List<StrategyTemplate> selectByDestName(String name) {

        return repository.findByDestName(name);
    }


    //通过主题id查询关联目的地
    private List<StatisVO> queryDestsByThemeId(Long themeId) {
        List<StrategyTemplate> list = repository.findByThemeId(themeId);
        List<StatisVO> vos = new ArrayList<>();
        List<String> names = new ArrayList<>();  //保存已经添加到list中目的地名
        for (StrategyTemplate st : list) {
            if(!names.contains(st.getDestName())){
                StatisVO vo = new StatisVO();
                vo.setId(st.getDestId());
                vo.setName(st.getDestName());
                vos.add(vo);
                names.add(st.getDestName());
            }

        }
        return vos;
    }

    //分组查询
    private List<StatisVO> statisVOGroup(String idField, String nameField, String groupName, BoolQueryBuilder query) {
        List<CompositeValuesSourceBuilder<?>> sources = new ArrayList<>();
        //多列分组: id属性对象
        TermsValuesSourceBuilder idSource = new TermsValuesSourceBuilder("id");
        idSource.field(idField);
        //多列分组: name属性对象
        TermsValuesSourceBuilder nameSource = new TermsValuesSourceBuilder("name");
        nameSource.field(nameField);

        sources.add(idSource);
        sources.add(nameSource);
        //多列分组查询对象:
        //参数1:分组查询结果操作名称
        //参数2:分组查询的列对象集合
        CompositeAggregationBuilder aggregationBuilder =
                new CompositeAggregationBuilder(groupName, sources);
        //实现相关步骤:
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();

        builder.addAggregation(aggregationBuilder);  //分组语句
        builder.withPageable(PageRequest.of(0, 1)); //分页
        //查询条件
        if (query != null) {
            builder.withQuery(query);
        }
        //查询DSL之后的结果
        AggregatedPage<StrategyTemplate> search = (AggregatedPage<StrategyTemplate>)
                repository.search(builder.build());
        //分组结果
        InternalComposite themeGroup = search.getAggregations().get(groupName);

        StatisVO vo = null;
        List<StatisVO> list = new ArrayList<>();
        for (CompositeAggregation.Bucket bucket : themeGroup.getBuckets()) {
            //主题
            Long id = Long.parseLong(bucket.getKey().get("id").toString());
            String name = bucket.getKey().get("name").toString();
            Long count = bucket.getDocCount();
            vo = new StatisVO(id, name, count);
            list.add(vo);
        }
        //1:按关联目的地的数量多少排序
        //排序结果int 类型:
        //大于0:大于  小于0:小于  等于0:等于
        Collections.sort(list, new Comparator<StatisVO>() {
            @Override
            public int compare(StatisVO o1, StatisVO o2) {
                Long ret = o2.getCount() - o1.getCount();
                return ret.intValue();
            }
        });
        return list;
    }


}
