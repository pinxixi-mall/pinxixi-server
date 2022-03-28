package com.pinxixi.controller.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 生成用户订单
 */
@Data
public class ClientOrderCreateParam {

    @ApiModelProperty("订单购物车项id数组")
    private Long[] cartIds;

    @ApiModelProperty("优惠金额")
    private Float orderCoupon;

}
