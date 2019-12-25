package cn.wolfcode.luowowo.comment.repository;

import cn.wolfcode.luowowo.comment.domain.StrategyComment;
import cn.wolfcode.luowowo.comment.domain.TravelComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * MongoDB 操作攻略评论的crud接口, 功能类似于mybatis中 Mapper
 * 但是功能更加强大, 因为依赖spring-data-jpa这个
 *
 * extends MongoRepository
 *   第一个泛型:操作文档的类型对象:StrategyComment
 *   第二个泛型:文档类型对象的id主键类型: string
 *
 *   @Repository:  spring 加载时会解析式该注解, 为该注解下接口创建实现类
 *
 */
@Repository
public interface ITravelCommentRepository extends MongoRepository<TravelComment, String> {
}
