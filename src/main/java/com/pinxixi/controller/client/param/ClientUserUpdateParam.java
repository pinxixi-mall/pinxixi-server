package com.pinxixi.controller.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import reactor.util.annotation.Nullable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class ClientUserUpdateParam {

    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 3, message = "用户名长度不能小于3位")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("手机号")
    //@Pattern(regexp = "^1[3456789][0-9]{9}$", message = "手机号格式不正确")
    private String phone;

    @ApiModelProperty("邮箱")
    //@Pattern(regexp = "^\\s*\\w+(?:\\.?[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$", message = "邮箱格式不正确")
    private String email;

    @ApiModelProperty("头像")
    private String avatar;

}
