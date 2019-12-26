package cn.wolfcode.luowowo.cache.service;

import cn.wolfcode.luowowo.cache.domain.AnswerStatisVO;

import java.util.List;

/**
 * 回答的数据统计
 */
public interface IAnswerStatisVOService {
    /**
     * 问答模块,用户回答后,回复数量增加1
     * @param answerId 回答的id
     * @param userId    用户的id
     * @param increase  增加量
     */
    void replynumIncrease(String answerId,Long userId, int increase);


    /**
     * 问答模块,用户回答内容长度超过150,加一个金牌
     * @param answerId 回答的id
     * @param userId    用户的id
     * @param increase  增加量
     */
    void medalnumIncrease(String answerId, Long userId, int increase);

    /**
     * 查询问答模块的回答次数排行榜
     * @return
     */
    List<AnswerStatisVO> selectReplyRank();

    /**
     * 查询问答模块的金牌排行榜
     * @return
     */
    List<AnswerStatisVO> selectMedalRankList();
    /**
     * 问答模块,用户回复内容被顶了
     * @param answerId 回答的id
     * @param userId    用户的id
     * @param increase  增加量
     */
    void thumbsupnumIncrease(String answerId, long userId, int increase);

    /**
     * 查询问答模块的金牌排行榜
     * @return
     */
    List<AnswerStatisVO> selectThumbsupRankList();

}
