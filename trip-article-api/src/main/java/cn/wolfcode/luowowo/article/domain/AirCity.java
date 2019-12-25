package cn.wolfcode.luowowo.article.domain;

import cn.wolfcode.luowowo.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class AirCity extends BaseDomain {
    // 城市名
    private String name;

    // 城市拼音
    private String pinyin;

    // 机场
    private String airport;

    // 三字码
    private String ICAOCode;
}
