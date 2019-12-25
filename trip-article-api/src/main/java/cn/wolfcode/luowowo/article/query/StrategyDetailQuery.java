package cn.wolfcode.luowowo.article.query;

import cn.wolfcode.luowowo.common.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StrategyDetailQuery extends QueryObject {

    private Long destId= -1L;  //目的的
    private Long tagId = -1L;  //标签
}
