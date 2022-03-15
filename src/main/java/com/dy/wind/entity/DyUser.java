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

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="dy_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "dy_user")
public class DyUser implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "uid", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private String uid;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value="用户名")
    @NotNull(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value="密码")
    @NotNull(message = "密码不能为空")
    private String password;

    /**
     * 地区
     */
    @TableField(value = "area")
    @ApiModelProperty(value="地区")
    private String area;

    /**
     * 身份
     */
    @TableField(value = "`identity`")
    @ApiModelProperty(value="身份")
    private String identity;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    /**
     * 删除标志位，注销为1,非0
     */
    @TableField(value = "ny_id")
    @ApiModelProperty(value="删除标志位，注销为1,非0")
    private Integer nyId;

    private static final long serialVersionUID = 1L;

    public static final String COL_UID = "uid";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";

    public static final String COL_AREA = "area";

    public static final String COL_IDENTITY = "identity";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_NY_ID = "ny_id";
}