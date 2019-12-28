package cn.wolfcode.luowowo.article.domain;

import cn.wolfcode.luowowo.common.domain.BaseDomain;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AirTicketOrder extends BaseDomain {

    private UserInfo user;

    private AirTicket airticket;

    private String ordernum;

    private Date creatime;

    private Integer price;


}