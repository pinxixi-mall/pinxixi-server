package com.pinxixi.controller.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ClientOrderUpdateParam {

    @ApiModelProperty("订单id")
    @NotNull(message = "订单id不能为空")
    private Long orderId;

    @ApiModelProperty("订单状态")
    private Byte orderStatus;

    @ApiModelProperty("支付状态")
    private Byte paymentStatus;

    @ApiModelProperty("支付类型：1-支付宝，2-微信")
    private Byte paymentType;

    @ApiModelProperty("支付时间")
    private Date paymentTime;

    @ApiModelProperty("删除标识：0-未删除，1-已删除")
    private Byte isDeleted;

}
