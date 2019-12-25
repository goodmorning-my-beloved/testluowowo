package cn.wolfcode.luowowo.comment.servcie.impl;

import cn.wolfcode.luowowo.comment.domain.TravelComment;
import cn.wolfcode.luowowo.comment.repository.ITravelCommentRepository;
import cn.wolfcode.luowowo.comment.service.ITravelCommentService;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class TravelCommentServiceImpl implements ITravelCommentService {

    /**
     * spring-data 会自动注入ITravelCommentRepository实现类
     * <p>
     * ITravelCommentRepository 接口继承MongoRepository
     * 拥有了 分页,排序,crud基本功能
     * 底层实现 : AOP 操作--动态代理
     */
    @Autowired
    private ITravelCommentRepository repository;

    //使用较为底层的贾琏欲执事, 实现mongodb操作, 这里用它来实现较为复杂操作
    @Autowired
    private MongoTemplate template;


    @Override
    public TravelComment saveOrUpdate(TravelComment comment, UserInfo userInfo) {
        comment.setCity(userInfo.getCity());
        comment.setUsername(userInfo.getNickname());
        comment.setUserId(userInfo.getId());
        comment.setLevel(userInfo.getLevel());
        comment.setHeadUrl(userInfo.getHeadImgUrl());

        //添加或更新
        if (!StringUtils.hasLength(comment.getId())) {
            comment.setCreateTime(new Date());
        }
        //看看是否是评论的评论
        if (TravelComment.TRAVLE_COMMENT_TYPE == comment.getType()) {
            //评论的评论
            if (StringUtils.hasLength(comment.getRefComment().getId())) {
                //把评论的评论查出来设置进去
                comment.setRefComment(repository.findById(comment.getRefComment().getId()).get());
            }
        }

        repository.save(comment);
        return comment;
    }

    @Override
    public long selectCountByTravelid(Long travelId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("travelId").is(travelId));
        long count = template.count(query, TravelComment.class);
        return count;
    }

    @Override
    public List<TravelComment> selectCommentByTravelId(Long id) {
        Query query=new Query();
        query.addCriteria(Criteria.where("travelId").is(id)).with(Sort.by(Sort.Direction.DESC,"createTime"));
        return template.find(query,TravelComment.class);

    }
}
