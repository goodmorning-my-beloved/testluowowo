package cn.wolfcode.luowowo.search.service.impl;

import cn.wolfcode.luowowo.search.query.SearchQueryObject;
import cn.wolfcode.luowowo.search.service.ISearchService;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements ISearchService {

    @Autowired
    private ElasticsearchTemplate template;


    //类比:select * from xxx where  title like  %#{keyword}% or subTitle like %#{keyword}%  or summary like %#{keyword}%
    //关键字: keyword = 广州
    //以title为例:
    //原始匹配: "有娃必看,广州长隆野生动物园全攻略"
    //高亮显示后:"有娃必看,<span style="color:red;">广州</span>长隆野生动物园全攻略"

    @Override
    public <T> Page<T> searchWithHighlight(String index, String type, Class<T> clz, SearchQueryObject qo, String... fields) {
        String preTags = "<span style='color:red;'>";
        String postTags = "</span>";

        //需要进行高亮显示的字段对象, 他是一个数组, 个数由搜索的字段个数决定: fields 个数决定
        //fields : title subTitle  summary
        HighlightBuilder.Field[] fs = new HighlightBuilder.Field[fields.length];
        for(int i = 0; i < fs.length; i++){
            //最终查询结果: <span style="color:red;">广州</span>
            fs[i] = new HighlightBuilder.Field(fields[i])
                    .preTags(preTags)  //拼接高亮显示关键字的开始的样式   <span style="color:red;">
                    .postTags(postTags);//拼接高亮显示关键字的结束的样式   </span>
        }

        NativeSearchQueryBuilder searchQuery = new NativeSearchQueryBuilder();
        searchQuery.withIndices(index)  //设置搜索索引
                .withTypes(type);   // 设置搜索类型
        /*"query":{
            "multi_match": {
                "query": "广州",
                "fields": ["title","subTitle","summary"]
            }
        },*/
        searchQuery.withQuery(QueryBuilders.multiMatchQuery(qo.getKeyword(), fields));  //拼接查询条件
        /**
         "from": 0,
         "size":3,
         */
        searchQuery.withPageable(qo.getPageableNoSort());   //分页操作

        //高亮显示
        /**
            "highlight": {
                "fields" : {
                    "title" : {},
                    "subTitle" : {},
                    "summary" : {}
                }
            }
         */
        searchQuery.withHighlightFields(fs);

        //调用template.queryForPage 实现结果处理
        //参数1:DSL语句封装对象
        //参数2:返回Page对象中list的泛型
        //参数3:SearchResultMapper 全文搜索返回的结果处理对象
        //     功能: 将DSL语句执行结果处理成Page 分页对象
        return template.queryForPage(searchQuery.build(), clz, new SearchResultMapper() {


            ///mapResults  真正处理DSL语句返回结果 方法
            //参数1: DSL语句查询结果
            //参数2: 最终处理完之后, 返回Page对象中list的泛型
            //参数3: 分页对象
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
                List<T> list = new ArrayList<>();
                SearchHits hits = response.getHits(); //结果对象中hist 里面包含全文搜索结果集
                SearchHit[] searchHits = hits.getHits();//结果对象中hist的hit 里面包含全文搜索结果集
                for (SearchHit searchHit : searchHits) {

                    //仅仅是原始的结果数据,此时查询字段某有高亮显示效果
                    T t = JSON.parseObject(searchHit.getSourceAsString(), clazz);

                    //必须使用拥有高亮显示的效果字段替换原先的数据
                    //参数1: 原始对象(字段中没有高亮显示)
                    //参数2:具有高亮显示效果字段, 他是一个map集合, key: 高亮显示字段名, value: 高亮显示字段值对象
                    //参数3:需要替换所有字段
                    highlightFieldsCopy(t, searchHit.getHighlightFields(), fields);
                    list.add(t);
                }

                //将结果集封装成分页对象Page : 参数1:查询数据, 参数2:分页数据, 参数3:查询到总记录数
                AggregatedPage<T> result = new AggregatedPageImpl<T>((List<T>) list, pageable,
                        response.getHits().getTotalHits());
                return result;
            }
        });
    }


    //fields: title subTitle summary
    private <T> void highlightFieldsCopy(T t, Map<String, HighlightField> map, String ...fields){

        Map<String, String> mm = new HashMap<>();

        for (String field : fields) {

            HighlightField hf = map.get(field);
            if (hf != null) {
                //获取高亮显示字段值, 因为是一个数组, 所有使用string拼接
                Text[] fragments = hf.fragments();
                String str = "";
                for (Text text : fragments) {
                    str += text;
                }
                mm.put(field, str);  //使用map对象将所有能替换字段先缓存, 后续统一替换
                //BeanUtils.setProperty(t,field,  str);  识别一个替换一个
            }
        }
        try {
            BeanUtils.copyProperties(t, mm);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
