package cn.wolfcode.luowowo.article.service;

import cn.wolfcode.luowowo.article.domain.DestinationCommendTheme;

import java.util.List;

public interface IDestinationCommendThemeService {
    //删除
    int deleteByPrimaryKey(Long id);
    //保存
    int insert(DestinationCommendTheme record);
    //查询单个
    DestinationCommendTheme selectByPrimaryKey(Long id);
    //查询多个
    List<DestinationCommendTheme> selectAll();
    //更新
    int updateByPrimaryKey(DestinationCommendTheme record);
}
