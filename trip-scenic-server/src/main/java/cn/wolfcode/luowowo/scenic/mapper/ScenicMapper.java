package cn.wolfcode.luowowo.scenic.mapper;

import cn.woldcode.luowowo.scenic.domain.Scenic;

import java.util.List;

public interface ScenicMapper {
    List<Scenic> selectScenicTop5();

    List<Scenic> selectHotScenics();
}
