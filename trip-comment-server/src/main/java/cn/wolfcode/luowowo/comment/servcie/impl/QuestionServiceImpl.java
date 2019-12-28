package cn.wolfcode.luowowo.comment.servcie.impl;

import cn.wolfcode.luowowo.cache.service.IAnswerStatisVOService;
import cn.wolfcode.luowowo.comment.domain.Answer;
import cn.wolfcode.luowowo.comment.domain.Question;
import cn.wolfcode.luowowo.comment.repository.IQuestionRepository;
import cn.wolfcode.luowowo.comment.service.IAnswerService;
import cn.wolfcode.luowowo.comment.service.IQuestionService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private IQuestionRepository repository;

    @Reference
    private IAnswerStatisVOService answerStatisVOService;

    @Autowired
    private IAnswerService answerService;

    @Autowired
    private MongoTemplate template;

    @Override
    public String save(Question question) {
        if(question.getCreateTime()==null){
            question.setCreateTime(new Date());
        }
        repository.save(question);
        return question.getId();
    }

    @Override
    public Question selectById(String id) {
        Optional<Question> question = repository.findById(id);
        Question quest = question.get();
        return quest;
    }

    @Override
    public String saveAnswerByQuestionIdToList(Answer answer, String questionId) {
        Question question = selectById(questionId);
        question.setAnswernum(question.getAnswernum()+1);
        List<Answer> list = question.getList();
        if(answer.getContent().length()>150){
            answerStatisVOService.medalnumIncrease(answer.getId(),answer.getUserId(),1);
            answer.setMedal(Answer.ANSWER_GOLD_MEDAL);
        }
        //判断这个类型是否是评论的评论
        if(Answer.ANSWER_TYPE_ANSWER == answer.getType()){
            //判断refAnswer.id有没有值,如果有的话,那就查询出来,然后设置进去
            if(StringUtils.hasLength(answer.getRefAnswer().getId())){
                for (Answer a : list) {
                    if(a.getId().equals((answer.getRefAnswer().getId()))){
                        answer.setRefAnswer(a);
                    }
                }
            }
        }
        answerService.save(answer);
        list.add(answer);
        question.setList(list);
        answerStatisVOService.replynumIncrease(answer.getId(),answer.getUserId(),1);
        question.setBrowsenum(question.getBrowsenum()-1);
        this.save(question);
        return question.getId();
    }

    @Override
    public List<Question> selectAll() {
        List<Question> questions = repository.findAll();
        return questions;
    }

    @Override
    public boolean focusStatus(String questionId,long userId) {
        boolean falg = false;
        Question question = this.selectById(questionId);
        List<Long> focusUserList = question.getFocusUserList();
        if(focusUserList.contains(userId)){
            //已经存在,表示取消关注
            if(focusUserList.size()>1){
                for (Long uId : focusUserList) {
                    if(uId == userId){
                        focusUserList.remove(uId);
                        question.setFocusnum(question.getFocusnum() -1);
                    }
                }
            }else{
                //清空集合
                question.setFocusUserList(new ArrayList<>());
                question.setFocusnum(question.getFocusnum() -1);
            }
        }else{
            //不存在,表示可以关注
            focusUserList.add(userId);
            question.setFocusnum(question.getFocusnum() + 1);
            falg = true;
        }
        //保存最新数据到question中
        this.save(question);
        return falg;
    }

    @Override
    public int increaseAnswerThumbsupnum(String questionId, String answerId, int num) {
        Question question = this.selectById(questionId);
        List<Answer> list = question.getList();
        List<Answer> newList = new ArrayList<>();
        int thumbsupnum = 0;
        if(list!=null && list.size() > 0){
            for (Answer answer : list) {
                if(answer.getId().equals(answerId)){
                    answer.setThumbsupnum(answer.getThumbsupnum()+1);
                    thumbsupnum = answer.getThumbsupnum();
                }
                newList.add(answer);
            }
        }
        question.setList(newList);
        this.save(question);
        return thumbsupnum;
    }
}
