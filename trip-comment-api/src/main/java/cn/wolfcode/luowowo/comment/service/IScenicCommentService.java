package cn.wolfcode.luowowo.comment.service;

import cn.wolfcode.luowowo.comment.domain.ScenicComment;
import cn.wolfcode.luowowo.member.domain.UserInfo;

import java.util.List;

public interface IScenicCommentService {
    /**
     * 根基景点id查询景点评论
     * @param id
     * @return list
     */
    public List<ScenicComment> selectCommentByScenicId(Long id);

    /**
     * 根据用户查评论
     * @param id
     * @return
     */
    List<ScenicComment> selectCommentById(Long id);


    /**
     *  增加评论
     * @param comment
     * @param userInfo
     */
    void addAnswer(ScenicComment comment, UserInfo userInfo);
}
