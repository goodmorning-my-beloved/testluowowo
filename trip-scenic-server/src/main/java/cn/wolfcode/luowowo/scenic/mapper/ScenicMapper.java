package cn.wolfcode.luowowo.scenic.mapper;

import cn.woldcode.luowowo.scenic.domain.Scenic;
import cn.woldcode.luowowo.scenic.query.ScenicQuery;

import java.util.List;

public interface ScenicMapper {
    List<Scenic> selectScenicTop5();

    List<Scenic> selectHotScenics();

    List<Scenic> selectForList(ScenicQuery qo);

    Scenic selectScenicById(Long id);

    List<Scenic> selectByParentId(Long parentId);
}
