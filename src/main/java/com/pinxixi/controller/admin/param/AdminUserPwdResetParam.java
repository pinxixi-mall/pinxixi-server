package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AdminUserPwdResetParam {

    @ApiModelProperty("原密码")
    @NotEmpty(message = "原密码不能为空")
    private String oldPassword;

    @ApiModelProperty("新密码")
    @NotEmpty(message = "新密码不能为空")
    private String newPassword;

    @ApiModelProperty("确认密码")
    @NotEmpty(message = "确认密码不能为空")
    private String confirmPassword;

}
