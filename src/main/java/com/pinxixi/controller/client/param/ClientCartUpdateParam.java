package com.pinxixi.controller.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ClientCartUpdateParam {

    @ApiModelProperty("购物车项id")
    @NotNull(message = "购物车项id不能为空")
    private Long cartId;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("商品数量")
    @NotNull(message = "商品数量不能为空")
    @Min(value = 1, message = "商品数量不能小于1")
    @Max(value = 99, message = "商品数量不能大于99")
    private Integer goodsCount;

    @ApiModelProperty("删除标识：0-未删除，1-已删除")
    private Byte isDeleted;

}
