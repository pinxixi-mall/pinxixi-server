package com.pinxixi.controller.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class GoodsVO {

    @ApiModelProperty("商品ID")
    private Long goodsId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品图片")
    private String goodsImage;

    @ApiModelProperty("商品分类ID")
    private Long goodsCategoryId;

    @ApiModelProperty("商品描述")
    private String goodsDesc;

    @ApiModelProperty("商品价格")
    private Float goodsPrice;

    @ApiModelProperty("商品库存")
    private Integer goodsStock;

    @ApiModelProperty("商品状态（0-已下架，1-上架中）")
    private Byte goodsStatus;

    @ApiModelProperty("商品类型（1-普通，2-推荐）")
    private Byte goodsType;

    @ApiModelProperty("商品详情")
    private String goodsDetail;

}
