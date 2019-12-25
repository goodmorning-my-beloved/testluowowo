package cn.wolfcode.luowowo.comment.domain;

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
 * 问题
 */
@Setter
@Getter
@Document("question")   //文档所在集合名字
public class Question implements Serializable {
    public static final int QUESTION_STATE_REFUSE=0;
    public static final int QUESTION_STATE_COMMON=1;

    @Id
    private String id;  //spring - data 默认封装成 ObjectId

    private Long userId;    //用户id
    private String username;  //用户名
    private String city;       //城市
    private int level;      //等级
    private String headUrl;     //头像

    private Long destId;//目的地id

    private String destName;//目的地名字

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;//创建时间

    private int state=Question.QUESTION_STATE_COMMON;//状态

    private String title;//问题的标题

    private String content;//问题的内容

    private int focusnum;//关注数量

    private int browsenum;//浏览数

    private int answernum;//回答数量

    private List<Answer> list=new ArrayList<>();
}
