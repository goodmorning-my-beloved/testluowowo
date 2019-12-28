package cn.wolfcode.luowowo.comment.servcie.impl;

import cn.wolfcode.luowowo.comment.domain.ScenicComment;
import cn.wolfcode.luowowo.comment.repository.IScenicCommentRepository;
import cn.wolfcode.luowowo.comment.service.IScenicCommentService;
import cn.wolfcode.luowowo.comment.util.ImgUtil;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.wiring.ClassNameBeanWiringInfoResolver;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScenicServiceImpl implements IScenicCommentService{

    @Autowired
    private IScenicCommentRepository repository;

    @Override
    public List<ScenicComment> selectCommentByScenicId(Long id) {
        List<ScenicComment> scenicComments = repository.findByScenicIdAndRefId(id, null);
        //遍历获取到所有的图片字符串
        for (ScenicComment scenicComment : scenicComments) {
            String imgs = scenicComment.getImgs();
            if(imgs!=null){
                // 切割字符串, 遍历放到图片对象中
                String[] split = imgs.split(",");
                List<ImgUtil> list = new ArrayList<>();
                for (String img : split) {
                    ImgUtil imgUtil = new ImgUtil();
                    imgUtil.setImg(img);
                    list.add(imgUtil);
                }
                scenicComment.setImgList(list);
            }

            // 设置评论的评论
            scenicComment.setCommentList(repository.findByRefId(scenicComment.getId()));
                /*// 是否有评论的评论
            if (scenicComment.getRefComment().getId()!=null){
                for (ScenicComment comment : scenicComments) {
                    if (comment.getId() == scenicComment.getRefComment().getId()){
                        comment.getCommentList().add(scenicComment);
                    }
                }
            }*/
        }
        //List<ScenicComment> all = repository.findAll();
        return scenicComments;
    }

    @Override
    public void addAnswer(ScenicComment comment, UserInfo userInfo) {
        comment.setUsername(userInfo.getNickname());
        comment.setHeadUrl(userInfo.getHeadImgUrl());
        comment.setLevel(userInfo.getLevel());
        comment.setUserId(userInfo.getId());

        //添加或更新
        if (!StringUtils.hasLength(comment.getId())) {
            comment.setCreateTime(new Date());
        }

        // 判断是不是评论中的评论
        if (ScenicComment.TRAVLE_COMMENT_TYPE == comment.getType()){
            // 设置评论的评论
            if (StringUtils.hasLength(comment.getRefComment().getId())){
                comment.setRefId(comment.getRefComment().getId());
                comment.setRefComment(repository.findById(comment.getRefComment().getId()).get());
            }
        }

        repository.save(comment);

    }
}
