package com.dy.wind.exception;

import com.dy.wind.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Hasee
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 自动异常处理
     * @data: 2021/5/22-16:19
     * @method: error
     * @params: [e]
     * @return: com.wind.yygh.common.result.Result
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail();
    }
    /**
     * 手动异常处理
     * @data: 2021/5/22-16:22
     * @method: error
     * @params: [e]
     * @return: com.wind.yygh.common.result.Result
     */
    @ExceptionHandler(DyException.class)
    @ResponseBody
    public Result error(DyException e){
        e.printStackTrace();
        return Result.fail();
    }
}
