package cn.wolfcode.luowowo.search.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 统计数据vo值
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatisVO implements Serializable {

    private Long id;  //分组查询之后得到id (维度id)
    private String name; //分组查询之后得到name (维度name)
    private long count;  //分组查询之后得到统计数 (维度统计个数)


}
