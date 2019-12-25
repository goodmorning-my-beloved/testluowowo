package cn.wolfcode.luowowo.article.query;

import cn.wolfcode.luowowo.common.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DestinationQuery extends QueryObject {

    private int ishot = -1;  //是否热门

    private Long parentId = -1L;  //父id


}
