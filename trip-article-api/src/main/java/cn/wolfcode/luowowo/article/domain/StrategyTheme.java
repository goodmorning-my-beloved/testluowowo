package cn.wolfcode.luowowo.article.domain;

import cn.wolfcode.luowowo.common.domain.BaseDomain;
import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 攻略主题
 */
@Setter
@Getter
public class StrategyTheme extends BaseDomain {
    public static final int STATE_NORMAL = 0; //正常
    public static final int STATE_DISABLE = 1; //禁用

    private String name;  //主题名称
    private int state = STATE_NORMAL; //主题状态

    private int sequence; //序号
    public String getStateDisplay(){
        return state == STATE_NORMAL ? "正常" : "禁用";
    }
    public String getJsonString(){
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("state",state);
        map.put("sequence",sequence);
        return JSON.toJSONString(map);
    }

}