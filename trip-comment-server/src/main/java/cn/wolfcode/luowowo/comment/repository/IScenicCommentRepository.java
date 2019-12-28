package cn.wolfcode.luowowo.comment.repository;

import cn.wolfcode.luowowo.comment.domain.Answer;
import cn.wolfcode.luowowo.comment.domain.ScenicComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IScenicCommentRepository extends MongoRepository<ScenicComment,String> {
    List<ScenicComment> findByScenicId(Long id);

    List<ScenicComment> findByUserId(Long id);
    List<ScenicComment> findByScenicIdAndRefId(Long scenicId, String refId);
    List<ScenicComment> findByRefId(String id);
}
