package cn.woldcode.luowowo.scenic.query;

import cn.wolfcode.luowowo.common.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScenicQuery extends QueryObject {
    private Long destId; //目的地id
    private String type;  // 景点类型
}
