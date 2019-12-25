package cn.wolfcode.luowowo.article.mapper;

import cn.wolfcode.luowowo.article.domain.DestinationFilter;
import cn.wolfcode.luowowo.article.query.DestinationFilterQuery;

import java.util.List;

public interface DestinationFilterMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DestinationFilter record);

    DestinationFilter selectByPrimaryKey(Long id);

    List<DestinationFilter> selectAll();

    int updateByPrimaryKey(DestinationFilter record);
    //根据主题id查询目的地推荐
    List<DestinationFilter> selectByThemeId(Long themeId);

    List<DestinationFilter> selectForList(DestinationFilterQuery qo);
}