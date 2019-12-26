package cn.wolfcode.luowowo.article.service.impl;

import cn.wolfcode.luowowo.article.domain.DestinationCommendTheme;
import cn.wolfcode.luowowo.article.mapper.DestinationCommendThemeMapper;
import cn.wolfcode.luowowo.article.service.IDestinationCommendThemeService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DestinationCommendThemeServiceImpl implements IDestinationCommendThemeService {


    @Autowired
    private DestinationCommendThemeMapper destinationCommendThemeMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        destinationCommendThemeMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int insert(DestinationCommendTheme record) {
        destinationCommendThemeMapper.insert(record);
        return 0;
    }

    @Override
    public DestinationCommendTheme selectByPrimaryKey(Long id) {
        DestinationCommendTheme destinationCommendTheme = destinationCommendThemeMapper.selectByPrimaryKey(id);
        return destinationCommendTheme;
    }

    @Override
    public List<DestinationCommendTheme> selectAll() {
        List<DestinationCommendTheme> destinationCommendThemes = destinationCommendThemeMapper.selectAll();
        return destinationCommendThemes;
    }

    @Override
    public int updateByPrimaryKey(DestinationCommendTheme record) {
        destinationCommendThemeMapper.updateByPrimaryKey(record);
        return 0;
    }
}
