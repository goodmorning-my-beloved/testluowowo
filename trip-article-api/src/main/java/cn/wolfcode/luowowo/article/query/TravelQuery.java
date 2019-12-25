package cn.wolfcode.luowowo.article.query;

import cn.wolfcode.luowowo.common.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class TravelQuery extends QueryObject {
    private Long destId=-1L;
    private int orderType=1;
    private int travelTimeType=-1;
    private int perExpendType=-1;
    private int dayType=-1;
    private String orderBy = "t.createTime desc ";  //默认是最新



    public String getOrderBy(){
        if(orderType == 1){
            return "t.createTime desc " ;
        }else{
            return "t.viewnum desc";   //最热门
        }
    }

    public  TravelCondition getDays(){//出行天数
        return TravelCondition.days.get(dayType);
    }
    public  TravelCondition getPerExpend(){
        return TravelCondition.perExpend.get(perExpendType);
    }
    public  TravelCondition getTravelTime(){
        return TravelCondition.travelTime.get(travelTimeType);
    }
}
