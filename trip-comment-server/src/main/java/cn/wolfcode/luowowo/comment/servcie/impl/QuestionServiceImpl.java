package cn.wolfcode.luowowo.comment.servcie.impl;

import cn.wolfcode.luowowo.comment.domain.Answer;
import cn.wolfcode.luowowo.comment.domain.Question;
import cn.wolfcode.luowowo.comment.repository.IQuestionRepository;
import cn.wolfcode.luowowo.comment.service.IQuestionService;
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
        list.add(answer);
        question.setList(list);
        this.save(question);
        return question.getId();
    }

    @Override
    public List<Question> selectAll() {
        List<Question> questions = repository.findAll();
        return questions;
    }
}
