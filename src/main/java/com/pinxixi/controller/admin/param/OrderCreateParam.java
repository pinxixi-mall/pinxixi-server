package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class OrderCreateParam {

    @ApiModelProperty("订单ID")
    private Long orderId;

    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("用户ID")
    @NotNull(message = "用户ID不能为空")
    private Integer userId;

    @ApiModelProperty("订单总价")
    @NotNull(message = "订单总价不能为空")
    private Float orderPrice;

    @ApiModelProperty("订单状态")
    private Byte orderStatus;

    @ApiModelProperty("支付状态")
    private Byte paymentStatus;

    @ApiModelProperty("支付方式")
    private Byte paymentType;

    @ApiModelProperty("支付时间")
    private Date paymentTime;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

}
