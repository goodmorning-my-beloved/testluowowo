package cn.wolfcode.luowowo.cache.service;

import cn.wolfcode.luowowo.cache.domain.TravelStatisVO;

public interface ITravelStatisVOredisService {

    /**
     * 阅读数加1
     */
    void viewnumIncrease(Long id);


    /**
     * 查询对应的游记VO
     * @param id
     * @return
     */
    TravelStatisVO selectById(Long id);

    /**
     * 用户游记点评数量添加
     * @param id
     */
    void userTravelCommentAddNum(Long id);

    /**
     * 查询用户点评过的游记数
     * @param id
     * @return
     */
    int selectUserCommentNum(Long id);

    /**
     * 点赞操作
     * @param sid
     * @param id
     * @return
     */
    boolean Thumbup(Long sid, Long id);

    /**
     * 根据游记id查游记vo
     * @param sid
     * @return
     */
    TravelStatisVO selecttravelStatisVOById(Long sid);
}
