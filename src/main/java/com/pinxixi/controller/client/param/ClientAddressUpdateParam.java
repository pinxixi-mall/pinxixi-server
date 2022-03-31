package com.pinxixi.controller.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ClientAddressUpdateParam {

    @ApiModelProperty("地址id")
    @NotNull(message = "地址id不能为空")
    private Long addressId;

    @ApiModelProperty("收件人姓名")
    @NotEmpty(message = "收件人姓名不能为空")
    private String name;

    @ApiModelProperty("收件人手机号")
    @NotEmpty(message = "收件人手机号不能为空")
    private String tel;

    @ApiModelProperty("默认地址")
    private Byte isDefault;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("省")
    @NotEmpty(message = "省代码不能为空")
    private String provinceCode;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("市代码")
    @NotEmpty(message = "市代码不能为空")
    private String cityCode;

    @ApiModelProperty("区")
    @NotEmpty(message = "区不能为空")
    private String county;

    @ApiModelProperty("区代码")
    @NotEmpty(message = "区代码不能为空")
    private String countyCode;

    @ApiModelProperty("详细地址")
    @NotEmpty(message = "详细地址不能为空")
    private String addressDetail;

}
