package cn.wolfcode.luowowo.comment.servcie.impl;

import cn.wolfcode.luowowo.comment.domain.Answer;
import cn.wolfcode.luowowo.comment.repository.IAnswerRepository;
import cn.wolfcode.luowowo.comment.service.IAnswerService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    private IAnswerRepository answerRepository;

    @Autowired
    private MongoTemplate template;


    @Override
    public void save(Answer answer) {
        answerRepository.save(answer);
    }
}
