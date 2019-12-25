package cn.wolfcode.luowowo.article.mapper;

import cn.wolfcode.luowowo.article.domain.DestinationCommendTheme;
import java.util.List;

public interface DestinationCommendThemeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DestinationCommendTheme record);

    DestinationCommendTheme selectByPrimaryKey(Long id);

    List<DestinationCommendTheme> selectAll();

    int updateByPrimaryKey(DestinationCommendTheme record);
}