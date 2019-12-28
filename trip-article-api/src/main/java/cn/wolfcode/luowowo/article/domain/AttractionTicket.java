package cn.wolfcode.luowowo.article.domain;

import cn.wolfcode.luowowo.common.domain.BaseDomain;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AttractionTicket extends BaseDomain {

    private String coverUrl;//背景图
    private Integer praisenum;//好评率
    private String name;//景点名
    private Integer price;//价格
    private Destination dest;//目的地名
    private int state;//状态
    private String sequence;//排序
    private DestinationCommendTheme theme;//主题

}