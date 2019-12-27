package cn.woldcode.luowowo.scenic.service;

import cn.woldcode.luowowo.scenic.domain.Scenic;
import cn.woldcode.luowowo.scenic.query.ScenicQuery;
import com.github.pagehelper.PageInfo;

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

    /**
     * 分页信息
     * @param qo
     * @return
     */
    PageInfo page(ScenicQuery qo);
}
