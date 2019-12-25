package cn.wolfcode.luowowo.article.domain;

import cn.wolfcode.luowowo.common.domain.BaseDomain;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DestinationCommendTheme extends BaseDomain {
    private Integer type;//主题类型

    private String name;//主题名称

    private String coverUrl;//主题背景
    private Integer sequence;//排序


}