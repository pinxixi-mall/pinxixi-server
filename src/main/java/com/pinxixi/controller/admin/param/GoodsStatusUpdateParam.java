package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 商品状态修改接口参数
 */
@Data
public class GoodsStatusUpdateParam {

    @ApiModelProperty("商品id")
    @NotNull(message = "商品ID不能为空")
    private Long goodsId;

    @ApiModelProperty("商品状态：0-下架，1-上架")
    @NotNull(message = "商品状态不能为空")
    private Byte goodsStatus;

}
