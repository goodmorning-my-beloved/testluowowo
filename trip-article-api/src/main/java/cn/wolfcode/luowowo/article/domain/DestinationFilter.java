package cn.wolfcode.luowowo.article.domain;

import cn.wolfcode.luowowo.common.domain.BaseDomain;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DestinationFilter extends BaseDomain {

    private Destination dest;//关联目的地

    private String title;//简介

    private String hottop;//热门显示

    private String route;//路线

    private String month;//月份

    private int holiday;//假期

    private DestinationCommendTheme theme;//主题

    private String days;//天数

    private String sequence;//排序

    private String coverUrl;//封面


}