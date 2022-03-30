package com.pinxixi.controller.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ClientAddressAddParam {

    @ApiModelProperty("用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

    @ApiModelProperty("收件人姓名")
    @NotEmpty(message = "收件人姓名不能为空")
    private String name;

    @ApiModelProperty("收件人手机号")
    @NotEmpty(message = "收件人手机号不能为空")
    private String tel;

    @ApiModelProperty("默认地址")
    private Byte isDefault;

    @ApiModelProperty("省")
    @NotEmpty(message = "省不能为空")
    private String province;

    @ApiModelProperty("市")
    @NotEmpty(message = "市不能为空")
    private String city;

    @ApiModelProperty("区")
    @NotEmpty(message = "区不能为空")
    private String region;

    @ApiModelProperty("详细地址")
    @NotEmpty(message = "详细地址不能为空")
    private String addressDetail;

}
