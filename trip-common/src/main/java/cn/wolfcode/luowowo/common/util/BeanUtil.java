package cn.wolfcode.luowowo.common.util;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanUtil {

    public static void copyProperties(Object dest,Object org){
        try {
            BeanUtils.copyProperties(dest,org);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
