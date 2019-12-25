package cn.wolfcode.luowowo.article.service;

import cn.wolfcode.luowowo.article.domain.DestinationCommendTheme;
import cn.wolfcode.luowowo.article.domain.DestinationFilter;
import cn.wolfcode.luowowo.article.query.DestinationFilterQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IDestinationFilterService {
    int deleteByPrimaryKey(Long id);

    int insert(DestinationFilter record);

    DestinationFilter selectByPrimaryKey(Long id);

    List<DestinationFilter> selectAll();

    int updateByPrimaryKey(DestinationFilter record);

    /**
     * 根据主题id查询目的地推荐
     * @param themeId
     * @return
     */
    List<DestinationFilter> selectByThemeId(Long themeId);
    /**
     * 分页查询
     */
    PageInfo<DestinationFilter> query(DestinationFilterQuery qo);
}
