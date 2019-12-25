package cn.wolfcode.luowowo.comment.service;

import cn.wolfcode.luowowo.comment.domain.StrategyComment;
import cn.wolfcode.luowowo.comment.query.StrategyCommentQuery;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import org.springframework.data.domain.Page;

public interface IStrategyCommentService {
    /**
     * 增加或修改
     * @param comment
     */
    void saveOrUpdate(StrategyComment comment,UserInfo userInfo);

    /**
     * 查询攻略评论
     * @param qo
     * @return
     */
    Page selectStrategyComment(StrategyCommentQuery qo);

    /**
     * 评论点赞与取消
     * @param commentId 评论id
     * @param userId 点赞者
     */
    void commentThumbUp(String commentId, Long userId);


}
