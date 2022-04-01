package com.pinxixi.controller.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class ClientUserRegisterParam {

    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 3, message = "用户名长度不能小于3位")
    //@Pattern(regexp = "^1[3456789][0-9]{9}$", message = "请输入正确的手机号")
    private String userName;

    @ApiModelProperty("用户密码")
    @NotEmpty(message = "用户密码不能为空")
    private String password;

    @ApiModelProperty("确认密码")
    @NotEmpty(message = "确认密码不能为空")
    private String confirmPassword;

}
