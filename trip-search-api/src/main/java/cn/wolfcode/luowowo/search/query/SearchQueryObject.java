package cn.wolfcode.luowowo.search.query;

import cn.wolfcode.luowowo.common.query.QueryObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Setter
@Getter
public class SearchQueryObject extends QueryObject{
    public static final int CONDITION_TYPE_ABROAD = 0;  //国外
    public static final int CONDITION_TYPE_CHINA = 1;  //国内
    public static final int CONDITION_TYPE_THEME = 2;   //主题



    public static final int SEARCH_TYPE_ALL = -1;   // 搜索所有
    public static final int SEARCH_TYPE_DEST = 0;   //目的地
    public static final int SEARCH_TYPE_STRATEGY = 1;   //攻略
    public static final int SEARCH_TYPE_TRAVEL = 2;   //游记
    public static final int SEARCH_TYPE_USER = 3;   //用户





    //条件的类别: 国内(provinceId)  国外(countryId)  主题(themeid)
    //搜索类型
    private int type = -1;

    private Long typeValue = -1L;  //国内(provinceId)  国外(countryId)  主题(themeid)

    private String orderBy = "viewnum";


    //分页对象
    public Pageable getPageable() {
        //参数1:当前页 -1
        //参数2:每页显示条数
        //参数3:排序对象
        return PageRequest.of(super.getCurrentPage()-1, super.getPageSize(),
                Sort.by(Sort.Direction.DESC, orderBy));
    }



    public Pageable getPageableNoSort() {
        //参数1:当前页 -1
        //参数2:每页显示条数
        //参数3:排序对象
        return PageRequest.of(super.getCurrentPage()-1, super.getPageSize());
    }



}
