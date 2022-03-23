package com.pinxixi.controller.client.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClientCartItemVO {

    @ApiModelProperty("购物车项id")
    private Long cartId;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("关联商品id")
    private Long goodsId;

    @ApiModelProperty("商品数量")
    private Integer goodsCount;

    @ApiModelProperty("商品图片")
    private String goodsImage;

    @ApiModelProperty("删除标识：0-未删除，1-已删除")
    private Byte isDeleted;

}
