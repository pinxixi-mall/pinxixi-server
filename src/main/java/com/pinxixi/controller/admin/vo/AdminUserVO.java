package com.pinxixi.controller.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AdminUserVO implements Serializable {

    @ApiModelProperty("用户id")
    private int userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("是否锁定：0-否，1-是")
    private Byte locked;
}
