package cn.wolfcode.luowowo.article.domain;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DestinationDaysCondition {
    private int minDay;
    private int maxDay;

    public static final Map<Integer,DestinationDaysCondition> TRAVEL_DAYS = new HashMap<>();
    static {
        TRAVEL_DAYS.put(1,new DestinationDaysCondition(2,3));
        TRAVEL_DAYS.put(2,new DestinationDaysCondition(4,5));
        TRAVEL_DAYS.put(3,new DestinationDaysCondition(6,9));
        TRAVEL_DAYS.put(4,new DestinationDaysCondition(10,Integer.MAX_VALUE));
    }
}
