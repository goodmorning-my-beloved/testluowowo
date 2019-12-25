package cn.wolfcode.luowowo.cache.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class AnswerStatisVO implements Serializable {

    private String answerId;//回答的id

    private Long userId;    //用户id
    private String username;  //用户名
    private String city;       //城市
    private int level;      //等级
    private String headUrl;     //头像

    private int replynum;//回答的次数
    private int medalnum;//金牌数量
    private int thumbsupnum;//顶的数量
}
