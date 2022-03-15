package com.dy.wind.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value="dy_manage_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "dy_manage_order")
public class DyManageOrder implements Serializable {
    /**
     * 唯一主键
     */
    @TableId(value = "uid", type = IdType.INPUT)
    @ApiModelProperty(value="唯一主键")
    private String uid;

    /**
     * 反馈单号
     */
    @TableField(value = "single_number")
    @ApiModelProperty(value="反馈单号")
    private Long singleNumber;

    /**
     * 反馈结果单号
     */
    @TableField(value = "result_order")
    @ApiModelProperty(value="反馈结果单号")
    private Integer resultOrder;

    /**
     * 地区
     */
    @TableField(value = "order_area")
    @ApiModelProperty(value="地区")
    private String orderArea;

    /**
     * 问题类别
     */
    @TableField(value = "category")
    @ApiModelProperty(value="问题类别")
    private String category;

    /**
     * 反馈人姓名
     */
    @TableField(value = "feedback_name")
    @ApiModelProperty(value="反馈人姓名")
    private String feedbackName;

    /**
     * 反馈人手机号
     */
    @TableField(value = "feedback_phone")
    @ApiModelProperty(value="反馈人手机号")
    private String feedbackPhone;

    /**
     * 警情编号
     */
    @TableField(value = "alarm_number")
    @ApiModelProperty(value="警情编号")
    private Integer alarmNumber;

    /**
     * Team Viewer 地址
     */
    @TableField(value = "teamviewer_address")
    @ApiModelProperty(value="Team Viewer 地址")
    private String teamviewerAddress;

    /**
     * 问题描述
     */
    @TableField(value = "problem_description")
    @ApiModelProperty(value="问题描述")
    private String problemDescription;

    /**
     * 反馈处理状态，0为未处理，1为已处理
     */
    @TableField(value = "order_state")
    @ApiModelProperty(value="反馈处理状态，0为未处理，1为已处理")
    private String orderState;

    /**
     * 处理结果
     */
    @TableField(value = "order_feedback")
    @ApiModelProperty(value="处理结果")
    private String orderFeedback;

    /**
     * 表单创建时间
     */
    @TableField(value = "order_create_time")
    @ApiModelProperty(value="表单创建时间")
    private Date orderCreateTime;

    /**
     * 表单更新时间
     */
    @TableField(value = "order_update_time")
    @ApiModelProperty(value="表单更新时间")
    private Date orderUpdateTime;

    /**
     * 反馈时间
     */
    @TableField(value = "feedback_time")
    @ApiModelProperty(value="反馈时间")
    private Date feedbackTime;

    /**
     * 删除标志位，注销为1,非0
     */
    @TableField(value = "ny_id")
    @ApiModelProperty(value="删除标志位，注销为1,非0")
    private Integer nyId;

    private static final long serialVersionUID = 1L;

    public static final String COL_UID = "uid";

    public static final String COL_SINGLE_NUMBER = "single_number";

    public static final String COL_RESULT_ORDER = "result_order";

    public static final String COL_ORDER_AREA = "order_area";

    public static final String COL_CATEGORY = "category";

    public static final String COL_FEEDBACK_NAME = "feedback_name";

    public static final String COL_FEEDBACK_PHONE = "feedback_phone";

    public static final String COL_ALARM_NUMBER = "alarm_number";

    public static final String COL_TEAMVIEWER_ADDRESS = "teamviewer_address";

    public static final String COL_PROBLEM_DESCRIPTION = "problem_description";

    public static final String COL_ORDER_STATE = "order_state";

    public static final String COL_ORDER_FEEDBACK = "order_feedback";

    public static final String COL_ORDER_CREATE_TIME = "order_create_time";

    public static final String COL_ORDER_UPDATE_TIME = "order_update_time";

    public static final String COL_FEEDBACK_TIME = "feedback_time";

    public static final String COL_NY_ID = "ny_id";
}