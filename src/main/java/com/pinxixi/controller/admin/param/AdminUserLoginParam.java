package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AdminUserLoginParam {

    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("用户密码")
    @NotEmpty(message = "用户密码不能为空")
    private String password;
}
