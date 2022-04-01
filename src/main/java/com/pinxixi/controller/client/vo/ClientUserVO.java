package com.pinxixi.controller.client.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClientUserVO {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("用户头像")
    private String avatar;

}
