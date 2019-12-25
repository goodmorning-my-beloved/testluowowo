package cn.wolfcode.luowowo.search.service;

import cn.wolfcode.luowowo.search.query.SearchQueryObject;
import org.springframework.data.domain.Page;

/**
 * 所有es公共服务
 */
public interface ISearchService {

    /**
     * 全文搜索 + 高亮显示
     * @param index 索引
     * @param type  类型
     * @param clz   page结果集的泛型
     * @param qo    qo查询条件数据
     * @param fields 查询字段
     * @param <T> 泛型
     * @return  带有分页的全文搜索(高亮显示)结果集
     */
    <T> Page<T> searchWithHighlight(String index, String type, Class<T> clz, SearchQueryObject qo, String... fields);

}
