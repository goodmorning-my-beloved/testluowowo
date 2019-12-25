package cn.wolfcode.luowowo.article.query;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
public class TravelCondition {
    private int min;
    private int max;

    public TravelCondition(int min, int max){
        this.max=max;
        this.min=min;
    }

    public static Map<Integer,TravelCondition> days=new HashMap<>();//出行天数
    public static Map<Integer,TravelCondition> perExpend=new HashMap<>();
    public static Map<Integer,TravelCondition> travelTime=new HashMap<>();

    static{
        days.put(-1,new TravelCondition(0,Integer.MAX_VALUE));
        days.put(1,new TravelCondition(0,3));
        days.put(2,new TravelCondition(4,7));
        days.put(3,new TravelCondition(8,14));
        days.put(4,new TravelCondition(15,Integer.MAX_VALUE));

        perExpend.put(-1,new TravelCondition(0,Integer.MAX_VALUE));
        perExpend.put(1,new TravelCondition(1,999));
        perExpend.put(2,new TravelCondition(1000,6000));
        perExpend.put(3,new TravelCondition(6000,20000));
        perExpend.put(4,new TravelCondition(20000,Integer.MAX_VALUE));

        travelTime.put(-1,new TravelCondition(0,12));
        travelTime.put(1,new TravelCondition(1,2));
        travelTime.put(2,new TravelCondition(3,4));
        travelTime.put(3,new TravelCondition(5,6));
        travelTime.put(4,new TravelCondition(7,8));
        travelTime.put(5,new TravelCondition(9,10));
        travelTime.put(6,new TravelCondition(11,12));
    }

}
