package com.dy.wind.exception;

import com.dy.wind.result.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义全局异常类
 * @author qy
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "自定义全局异常类")
public class DyException extends RuntimeException {

    @ApiModelProperty(value = "异常状态码")
    private Integer code;
    /**
     * 通过状态码和错误消息创建异常对象
     * @data: 2021/5/26-16:52
     * @method: YyghException
     * @params: [message, code]
     * @return:
     */
    public DyException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     * @params:  resultCodeEnum
     */
    public DyException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }


}
