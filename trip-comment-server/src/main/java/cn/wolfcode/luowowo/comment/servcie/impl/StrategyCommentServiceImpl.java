package cn.wolfcode.luowowo.comment.servcie.impl;

import cn.wolfcode.luowowo.comment.domain.StrategyComment;
import cn.wolfcode.luowowo.comment.query.StrategyCommentQuery;
import cn.wolfcode.luowowo.comment.repository.IStrategyCommentRepository;
import cn.wolfcode.luowowo.comment.service.IStrategyCommentService;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StrategyCommentServiceImpl implements IStrategyCommentService {

    /**
     * spring-data 会自动注入IStrategyCommentRepository实现类
     *
     * IStrategyCommentRepository 接口继承MongoRepository
     * 拥有了 分页,排序,crud基本功能
     *    底层实现 : AOP 操作--动态代理
     */
    @Autowired
    private IStrategyCommentRepository repository;

    //使用较为底层的贾琏欲执事, 实现mongodb操作, 这里用它来实现较为复杂操作
    @Autowired
    private MongoTemplate template;


    @Override
    public void saveOrUpdate(StrategyComment comment,UserInfo userInfo) {
        comment.setCity(userInfo.getCity());
        comment.setCreateTime(new Date());
        comment.setHeadUrl(userInfo.getHeadImgUrl());
        comment.setLevel(userInfo.getLevel());
        comment.setUserId(userInfo.getId());
        comment.setUsername(userInfo.getNickname());
        repository.save(comment);
    }

    @Override
    public Page selectStrategyComment(StrategyCommentQuery qo) {
        //翻译:certeria,条件
        Query query=new Query();
        if(qo.getDetailId()!=-1){
            query.addCriteria(Criteria.where("detailId").is(qo.getDetailId()));
        }
        //查询总数,查总数不需要条件
        Long total=template.count(query,StrategyComment.class);

        //查list,list是需要加条件的,查询某页的所有数据,//翻译:Direction 指向
        Pageable pageable=PageRequest.of(qo.getCurrentPage()-1,qo.getPageSize(),
                Sort.Direction.DESC,"createTime");
        query.with(pageable);
        List<StrategyComment> commentList = template.find(query, StrategyComment.class);


        //这里需要list,pageable,long(总数)
        return new PageImpl(commentList,pageable,total);
    }

    @Override
    public void commentThumbUp(String commentId, Long userId) {
        //判断是点赞还是取消
        //去攻略评论里面查当前用户有没有对这评论点过赞
        Optional<StrategyComment> optionalStrategyComment = repository.findById(commentId);
        StrategyComment strategyComment = optionalStrategyComment.get();
        List<Long> thumbuplist = strategyComment.getThumbuplist();
        if(thumbuplist.contains(userId)){
            //取消点赞
            //评论点赞数减一,点赞集合删掉此用户,
            strategyComment.setThumbupnum(strategyComment.getThumbupnum()-1);
            thumbuplist.remove(userId);
            strategyComment.setThumbuplist(thumbuplist);
        }else{
            //点赞
            //评论点赞数加一,点赞集合加上此用户,
            strategyComment.setThumbupnum(strategyComment.getThumbupnum()+1);
            thumbuplist.add(userId);
            strategyComment.setThumbuplist(thumbuplist);
        }
        //统一更新此评论
        repository.save(strategyComment);
    }


}
