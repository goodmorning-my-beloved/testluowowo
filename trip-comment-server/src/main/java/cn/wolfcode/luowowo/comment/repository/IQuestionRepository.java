package cn.wolfcode.luowowo.comment.repository;

import cn.wolfcode.luowowo.comment.domain.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends MongoRepository<Question,String> {
}
