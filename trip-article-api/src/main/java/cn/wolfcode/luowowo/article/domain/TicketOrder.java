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
public class TicketOrder extends BaseDomain {

    private UserInfo userId;

    private String order_num;

    private TicketDetail ticketId;
    private Date creatime;


}