package cn.wolfcode.luowowo.article.mapper;

import cn.wolfcode.luowowo.article.domain.Travel;
import cn.wolfcode.luowowo.article.query.TravelQuery;
import cn.wolfcode.luowowo.member.domain.UserInfo;

import java.util.List;

public interface TravelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Travel record);

    Travel selectByPrimaryKey(Long id);

    List<Travel> selectAll();

    int updateByPrimaryKey(Travel record);

    List<Travel>  list(TravelQuery qo);

    List<Travel>  selectByDestId(TravelQuery qo);

    List<Travel> selectTravelTop3ByDestId(Long destId);

    List<Travel> selectForList(TravelQuery qo);

    UserInfo selectAuthorById(Long id);



    /**
     * 按目的地分组,再查出每一组的最高阅读量,进行组的排行,
     * 获得排行靠前十的目的地id,
     * @return
     */
    List<Travel> selectHotTravelsByViewnum();



}