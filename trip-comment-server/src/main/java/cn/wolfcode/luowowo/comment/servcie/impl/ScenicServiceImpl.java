package cn.wolfcode.luowowo.comment.servcie.impl;

import cn.wolfcode.luowowo.comment.domain.ScenicComment;
import cn.wolfcode.luowowo.comment.repository.IScenicCommentRepository;
import cn.wolfcode.luowowo.comment.service.IScenicCommentService;
import cn.wolfcode.luowowo.comment.util.ImgUtil;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScenicServiceImpl implements IScenicCommentService{

    @Autowired
    private IScenicCommentRepository repository;

    @Override
    public List<ScenicComment> selectCommentByScenicId(Long id) {
        List<ScenicComment> scenicComments = repository.findByScenicId(id);
        //遍历获取到所有的图片字符串
        for (ScenicComment scenicComment : scenicComments) {
            String imgs = scenicComment.getImgs();
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
        //List<ScenicComment> all = repository.findAll();
        return scenicComments;
    }

    @Override
    public List<ScenicComment> selectCommentById(Long id) {
        return repository.findByUserId(id);

    }
}
