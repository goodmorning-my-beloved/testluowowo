package cn.wolfcode.luowowo.search.vo;

import cn.wolfcode.luowowo.search.domain.DestinationTemplate;
import cn.wolfcode.luowowo.search.domain.StrategyTemplate;
import cn.wolfcode.luowowo.search.domain.TravelTemplate;
import cn.wolfcode.luowowo.search.domain.UserInfoTemplate;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//搜索结果vo
@Setter
@Getter
public class SearchResultVO implements Serializable {

    private Long total = 0L;

    private List<DestinationTemplate> dests = new ArrayList<>();
    private List<TravelTemplate> travels = new ArrayList<>();
    private List<StrategyTemplate> strategys = new ArrayList<>();
    private List<UserInfoTemplate> users = new ArrayList<>();
}
