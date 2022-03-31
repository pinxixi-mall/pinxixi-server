package com.pinxixi.controller.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 生成用户订单
 */
@Data
public class ClientOrderCreateParam {

    @ApiModelProperty("订单购物车项id数组")
    @NotNull
    private Long[] cartIds;

    @ApiModelProperty("地址id")
    @NotNull
    private Long addressId;

    @ApiModelProperty("优惠金额")
    private Float orderCoupon;

}
