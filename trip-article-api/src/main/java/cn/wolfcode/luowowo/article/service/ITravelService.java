package cn.wolfcode.luowowo.article.service;

import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.query.TravelQuery;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * 游记服务接口
 */
public interface ITravelService {
    /**
     * 分页查询游记
     * @param qo
     * @return
     */
    PageInfo queryForList(TravelQuery qo);

    /**
     * 根据目的地分页查游记
     * @param qo
     * @return
     */
    PageInfo queryForListByDestId(TravelQuery qo);

    /**
     * 保存或更新游记
     * @param travel
     */
    Long saveOrUpdate(Travel travel);

    /**
     * 根据id查游记
     * @param id
     * @return
     */
    Travel selectById(Long id);

    /**
     * 根据阅读量查指定目的地下前三篇游记
     * @param destId
     * @return
     */
    List<Travel> queryTravelTop3ByDestId(Long destId);

    /**
     * 分页查询
     * @param qo
     * @return
     */
    PageInfo query(TravelQuery qo);

    /**
     * 根据游记查作者
     * @param id
     * @return
     */
    UserInfo getAuthorById(Long id);

    /**
     * 查所有游记
     * @return
     */
    List<Travel> list();

    /**
     * 根据作者id查游记
     * @param id
     * @return
     */
    List<Travel> selectByAuthorId(Long id);
}
