package com.pinxixi.controller.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ClientCartAddParam {

    @ApiModelProperty("关联商品id")
    @NotNull(message = "关联商品id不能为空")
    private Long goodsId;

    @ApiModelProperty("商品数量")
    @NotNull(message = "商品数量不能为空")
    @Min(value = 1, message = "商品数量不能小于1")
    @Max(value = 99, message = "商品数量不能大于99")
    private Integer goodsCount;

}
