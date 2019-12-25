package cn.wolfcode.luowowo.article.mapper;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.query.DestinationQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DestinationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Destination record);

    Destination selectByPrimaryKey(Long id);

    List<Destination> selectAll();

    int updateByPrimaryKey(Destination record);

    List<Destination> selectDestsByDeep(int deep);


    List<Destination> selectDestByIds(Long[] destIds);

    List<Destination> selectForList(DestinationQuery qo);


    List<Destination> selectSubDestParentId(Long parentId);

    List<Destination> queryByDestIds(Long[] refIds);

    List<Destination> selectDestsByParentId(Long id);

    void updateHot(@Param("id") Long id, @Param("hot") int hot);
}