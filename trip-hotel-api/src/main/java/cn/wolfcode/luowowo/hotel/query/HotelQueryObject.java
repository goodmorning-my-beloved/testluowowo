package cn.wolfcode.luowowo.hotel.query;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class HotelQueryObject implements Serializable {
    private int currentPage=1; //当前页
    private int pageSize=3;   //每页显示记录数

    private String keyword;

    public String getKeyword(){
        if(keyword == null || "".equals(keyword.trim())){
            return null;
        }
        return  keyword;
    }
}
