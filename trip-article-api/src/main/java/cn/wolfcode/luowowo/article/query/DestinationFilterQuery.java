package cn.wolfcode.luowowo.article.query;

import cn.wolfcode.luowowo.common.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinationFilterQuery extends QueryObject {

    private Long month = -1L;//月份
    private Long themeId = -1L;//主题
    private Long days = -1L;//天数

}
