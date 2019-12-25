package cn.wolfcode.luowowo.article.mapper;

import cn.wolfcode.luowowo.article.domain.StrategyDetail;
import cn.wolfcode.luowowo.article.query.StrategyDetailQuery;
import cn.wolfcode.luowowo.article.vo.StrategyStatisPersistenceVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StrategyDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StrategyDetail record);

    StrategyDetail selectByPrimaryKey(Long id);

    List<StrategyDetail> selectAll();

    int updateByPrimaryKey(StrategyDetail record);

    List<StrategyDetail> selectForList(StrategyDetailQuery qo);


    void insertRelation(@Param("detailID") Long detailID, @Param("strategyTagID") Long strategyTagID);

    void deleteRelationByDetailId(Long id);

    void updateState(@Param("state") Long state, @Param("id") Long id);

    List<StrategyDetail> selectByDetailsTop3ByDestId(Long destId);

    List<StrategyDetail> selsectListByDestId(StrategyDetailQuery qo);

    void updateStatis(StrategyStatisPersistenceVO pvo);
}