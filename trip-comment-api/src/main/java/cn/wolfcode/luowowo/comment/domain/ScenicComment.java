package cn.wolfcode.luowowo.comment.domain;

import cn.wolfcode.luowowo.comment.util.ImgUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 景点评论
 */
@Setter
@Getter
@Document("scenic_comment")
public class ScenicComment implements Serializable{
    public static final int TRAVLE_COMMENT_TYPE_COMMENT = 0; //普通评论
    public static final int TRAVLE_COMMENT_TYPE = 1; //评论的评论

    @Id
    private String id;  //id

    // 景点id
    private Long scenicId;

    // 景点
    private String scenic;

    // 用户id
    private Long userId;

    // 用户名
    private String username;

    // 城市
    private String city;

    // 等级
    private int level;

    // 头像
    private String headUrl;

    // 评论内容图片
    private String imgs;

    // 创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTime;

    // 评论类别
    private int type = TRAVLE_COMMENT_TYPE_COMMENT;

    // 评论内容
    private String content;

    // 关联的评论id
    private String refId;

    // 关联的评论
    private ScenicComment refComment;

    // 评论的评论
    private List<ScenicComment> commentList = new ArrayList<>();

    private List<ImgUtil> imgList;

}
