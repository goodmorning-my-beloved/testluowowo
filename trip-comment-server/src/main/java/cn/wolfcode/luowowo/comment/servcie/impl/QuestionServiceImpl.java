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
        question.setCreateTime(new Date());
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
        List<Answer> list = question.getList();
        if(answer.getContent().length()>150){
            answerStatisVOService.medalnumIncrease(answer.getId(),answer.getUserId(),1);
            answer.setMedal(Answer.ANSWER_GOLD_MEDAL);
        }

        answerService.save(answer);
        list.add(answer);
        question.setList(list);

        answerStatisVOService.replynumIncrease(answer.getId(),answer.getUserId(),1);

        this.save(question);
        return question.getId();
    }

    @Override
    public List<Question> selectAll() {
        List<Question> questions = repository.findAll();
        return questions;
    }
}
