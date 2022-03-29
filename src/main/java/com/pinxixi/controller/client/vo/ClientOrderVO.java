package com.pinxixi.controller.client.vo;

import com.pinxixi.entity.OrderGoods;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ClientOrderVO {

    @ApiModelProperty("订单ID")
    private Long orderId;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("订单价格")
    private Float orderPrice;

    @ApiModelProperty("订单优惠")
    private Float orderCoupon;

    @ApiModelProperty("订单状态")
    private Byte orderStatus;

    @ApiModelProperty("支付状态")
    private Byte paymentStatus;

    @ApiModelProperty("支付类型")
    private Byte paymentType;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("支付时间")
    private Date paymentTime;

    @ApiModelProperty("订单商品")
    private List<OrderGoods> goodsList;

}
