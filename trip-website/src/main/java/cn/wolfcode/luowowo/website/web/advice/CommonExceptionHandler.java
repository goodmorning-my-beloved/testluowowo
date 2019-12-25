package cn.wolfcode.luowowo.website.web.advice;

import cn.wolfcode.luowowo.common.exception.LogicException;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import org.apache.commons.mail.EmailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(LogicException.class)
    @ResponseBody
    public Object logicException(Exception e){
        e.printStackTrace();
        return new AjaxResult(false,e.getMessage());
    }
    @ExceptionHandler({RuntimeException.class, EmailException.class})
    @ResponseBody
    public Object runtimeException(Exception e){
        e.printStackTrace();
        return new AjaxResult(false,"服务器繁忙,请稍后重试");
    }
}
