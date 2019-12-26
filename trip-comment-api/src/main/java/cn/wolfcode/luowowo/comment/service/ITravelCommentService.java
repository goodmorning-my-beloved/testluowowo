package cn.wolfcode.luowowo.comment.service;

import cn.wolfcode.luowowo.comment.domain.TravelComment;
import cn.wolfcode.luowowo.member.domain.UserInfo;

import java.util.List;

public interface ITravelCommentService {

    /**
     * 增加或修改游记评论
     * @param comment
     * @param userInfo
     */
    TravelComment saveOrUpdate(TravelComment comment, UserInfo userInfo);

    /**
     * 根据游记查游记下有多少评论
     * @param travelId
     * @return
     */
    long selectCountByTravelid(Long travelId);

    /**
     * 根据游记id查评论
     * @param id
     * @return
     */
    List<TravelComment> selectCommentByTravelId(Long id);

    /**
     * 查询用户评论过的游记
     * @param id
     * @return
     */
    List<TravelComment> selectCommentByUserid(Long id);
}
