package cn.wolfcode.luowowo.article.query;

import cn.wolfcode.luowowo.common.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinationFilterQuery extends QueryObject {
    public static final int DAYCONDITION=-1;
    public static final int DAYCONDITION1=1;
    public static final int DAYCONDITION2=2;
    public static final int DAYCONDITION3=3;
    public static final int DAYCONDITION4=4;

    private Long month = -1L;//月份
    private Long themeId = -1L;//主题
    private Integer travelTimeType = DAYCONDITION;//天数
   /* public DestinationDaysCondition getDays(){
        return DestinationDaysCondition.TRAVEL_DAYS.get(travelTimeType);
    }*/

}
