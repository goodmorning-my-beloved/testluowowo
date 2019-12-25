package cn.wolfcode.luowowo.comment.repository;

import cn.wolfcode.luowowo.comment.domain.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerRepository extends MongoRepository<Answer,String> {


}
