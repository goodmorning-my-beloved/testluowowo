package cn.wolfcode.luowowo.comment.service;

import cn.wolfcode.luowowo.comment.domain.Answer;
import cn.wolfcode.luowowo.comment.domain.Question;

import java.util.List;

/**
 * 问题接口
 */
public interface IQuestionService {

    String save(Question question);

    /**
     * 根据id查找这个对象
     * @param id
     * @return
     */
    Question selectById(String id);

    /**
     * 将这个问题对象查出来,然后将回答添加到问题对象的list属性当中
     * @param answer
     * @param questionId
     */
    String saveAnswerByQuestionIdToList(Answer answer, String questionId);

    /**
     * 查询所有的问题与问题的回答
     * @return
     */
    List<Question> selectAll();
}
