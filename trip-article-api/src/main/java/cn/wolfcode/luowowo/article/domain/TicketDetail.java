package cn.wolfcode.luowowo.article.domain;

import cn.wolfcode.luowowo.common.domain.BaseDomain;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketDetail extends BaseDomain {

    private String name;

    private Integer price;

    private String coverUrl;

    private String address;

    private String business_hours;

    private String shoulknow;

    private String introduce;


}