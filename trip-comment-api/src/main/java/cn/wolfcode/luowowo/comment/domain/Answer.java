package cn.wolfcode.luowowo.comment.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题
 */
@Setter
@Getter
@Document("answer")   //文档所在集合名字
public class Answer implements Serializable {
    public static final int ANSWER_GOLD_MEDAL=1;//金牌回答
    public static final int ANSWER_COMMON=0;//普通回答

    @Id
    private String id;  //spring - data 默认封装成 ObjectId

    private Long userId;    //用户id
    private String username;  //用户名
    private String city;       //城市
    private int level;      //等级
    private String headUrl;     //头像

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date replytime;//回复时间

    private int medal=Answer.ANSWER_COMMON;//是否是金牌,默认为普通回答

    private int thumbsupnum;//顶的数量

    private String summary;//部分回答的内容

    private String content;

}
