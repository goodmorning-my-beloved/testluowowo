package cn.wolfcode.luowowo.common.util;

import cn.wolfcode.luowowo.common.exception.LogicException;

/**
 * 参数判断工具类
 */
public class AssertUtil {

    public static void hasLength(String value, String msg) {
        if(value==null||"".equals(value.trim())){
            throw new LogicException(msg);
        }
    }

    public static void isEquals(String v1, String v2, String msg) {
        //作为一个工具类,应该是谁都可以用,我们这里要做判断
        if(v1==null||v2==null){
            throw new LogicException("参数不能为空");
        }
        if(!v1.equals(v2)){
            throw new LogicException(msg);
        }
    }
}
