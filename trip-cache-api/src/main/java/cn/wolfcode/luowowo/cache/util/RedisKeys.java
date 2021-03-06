package cn.wolfcode.luowowo.cache.util;

import cn.wolfcode.luowowo.common.util.Consts;
import lombok.Getter;

@Getter
public enum  RedisKeys {
    //用户回答金牌
    ANSWER_ZSET_SORT_MEDAL("answer_zset_sort_medal",null),
    //用户回答次数
    ANSWER_ZSET_SORT_REPLYNUM("answer_zset_sort_replynum",null),
    //用户回答被顶数量
    ANSWER_ZSET_SORT_THUMBSUPNUM("answer_zset_sort_thumbsupnum",null),

    VERFIYCODE("verfiyCode", Consts.VERIFY_CODE_VAI_TIME),
    //游记vo
    TRAVEL_STATIS_VO("travel_statis_vo",null),
    //攻略vo
    STRATEGY_STATIS_VO("strategy_statis_vo",null),
    //收藏者
    //热门攻略排行
    STRATEGY_ZSET_SORT_HOT("strategy_zset_sort_hot",null),
    //国内外攻略排行
    STRATEGY_ZSET_SORT_COMMEND("strategy_zset_sort_commend",null),
    STRATEGY_STATIS_FAVOR("strategy_statis_favor",null),
    STRATEGY_STATIS_THUMBUP("strategy_statis_thumbup",null),
    //用户游记点评数
    USER_TRAVEL_COMMENT("user_travel_comment",null),
    //游记点赞
    TRAVEL_STATIS_THUMBUP("travel_statis_thumbup",null),
    //游记点赞总数
    TRAVEL_TEUMBUP_SUM("travel_teumbup_sum",null),
    //用户收藏的攻略
    USER_STRATEGY_COOLECTION("user_strategy_coolection",null),
    //游记收藏
    USER_TRAVEL_COOLECTION("user_travel_coolection",null),
    //用户粉丝
    USER_FANS_COOLECTION("user_fans_coolection",null),
    //用户关注
    USER_FOCUS_COOLECTION("user_focus_coolection",null),
    VERFIYCODEVALI("verify_code_vali");
    private String prefix;
    private String verifyCodeVali;
    private Integer time;//时间是分
    private RedisKeys(String value){
        verifyCodeVali=value;
    }
    private RedisKeys(String prefix,Integer time){
        this.prefix=prefix;
        this.time=time;
    }
    public String join(String... values){
        StringBuilder sb=new StringBuilder();
        sb.append(prefix);
        for (String value : values) {
            sb.append(":").append(value);
        }
        return sb.toString();
    }
}
