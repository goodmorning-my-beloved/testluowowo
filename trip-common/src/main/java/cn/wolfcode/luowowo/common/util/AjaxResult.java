package cn.wolfcode.luowowo.common.util;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AjaxResult {
    private boolean success = true;
    private int code;
    private String msg;
    private Object data;

    public AjaxResult(){}
    public AjaxResult(boolean success){
        this.success = success;
    }



    public AjaxResult(boolean success, String msg){
        this.success = success;
        this.msg = msg;
    }


    //成功
    public static  final AjaxResult SUCCESS = new AjaxResult();
    //失败
    public static  final AjaxResult FAIL = new AjaxResult(false);

    public AjaxResult addData(Object data){
        this.data = data;
        return this;
    }
}
