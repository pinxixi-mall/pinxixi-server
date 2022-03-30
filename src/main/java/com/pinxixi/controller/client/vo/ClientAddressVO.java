package com.pinxixi.controller.client.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ClientAddressVO {

    @ApiModelProperty("地址id")
    private Long addressId;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("收件人姓名")
    private String name;

    @ApiModelProperty("收件人手机号")
    private String tel;

    @ApiModelProperty("默认地址")
    private Byte isDefault;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("区")
    private String county;

    @ApiModelProperty("详细地址")
    private String addressDetail;

}
