package com.dy.wind.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="dy_feedback_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryOrderVo implements Serializable {
    /**
     * 唯一主键
     */
    @ApiModelProperty(value="唯一主键")
    private String uid;

    /**
     * 反馈单号
     */
    @ApiModelProperty(value="反馈单号")
    private Integer singleNumber;

    /**
     * 地区
     */
    @ApiModelProperty(value="地区")
    private String orderArea;

    /**
     * 问题类别
     */
    @ApiModelProperty(value="问题类别")
    @NotNull(message = "请选择问题类别")
    private String category;

    /**
     * 反馈人姓名
     */
    @ApiModelProperty(value="反馈人姓名")
    private String feedbackName;

    /**
     * 反馈人手机号
     */
    @ApiModelProperty(value="反馈人手机号")
    private String feedbackPhone;

    /**
     * 警情编号
     */
    @ApiModelProperty(value="警情编号")
    private Integer alarmNumber;

    /**
     * Team Viewer 地址
     */
    @ApiModelProperty(value="Team Viewer 地址")
    private String teamviewerAddress;

    /**
     * 问题描述
     */
    @ApiModelProperty(value="问题描述")
    private String problemDescription;

    /**
     * 表单创建时间
     */
    @ApiModelProperty(value="表单创建时间")
    private Date orderCreateTime;

    /**
     * 表单更新时间
     */
    @ApiModelProperty(value="表单更新时间")
    private Date orderUpdateTime;

    /**
     * 删除标志位
     */
    @ApiModelProperty(value = "删除标志位")
    private Integer nyId;


}
