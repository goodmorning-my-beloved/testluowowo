package cn.woldcode.luowowo.scenic.service;

import cn.woldcode.luowowo.scenic.domain.Scenic;

import java.util.List;

public interface IScenicService {
    /**
     * 查询前五个热门景点
     * @return
     */
    List<Scenic> queryScenicTop5();

    /**
     * 查询热门景点
     * @return
     */
    List<Scenic> queryHotScenics();

}
