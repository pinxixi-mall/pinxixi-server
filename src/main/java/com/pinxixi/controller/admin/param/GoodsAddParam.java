package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class GoodsAddParam {

    private Long goodsId;

    @ApiModelProperty("商品名称")
    @NotEmpty(message = "商品名称不能为空")
    @Length(max = 100, message = "商品名称不能超过100个字符")
    private String goodsName;

    @ApiModelProperty("商品图片")
    @NotEmpty(message = "商品图片不能为空")
    private String goodsImage;

    @ApiModelProperty("商品分类ID")
    @NotNull(message = "商品分类不能为空")
    private Long goodsCategoryId;

    @ApiModelProperty("商品描述")
    @NotEmpty(message = "商品描述不能为空")
    private String goodsDesc;

    @ApiModelProperty("商品价格")
    @NotNull(message = "商品价格不能为空")
    private Float goodsPrice;

    @ApiModelProperty("商品库存")
    @NotNull(message = "商品库存不能为空")
    private Integer goodsStock;

    @ApiModelProperty("商品状态（0-已下架，1-上架中）")
    @NotNull(message = "商品状态不能为空")
    private Byte goodsStatus;

    @ApiModelProperty("商品类型（1-普通，2-推荐）")
    @NotNull(message = "商品类型不能为空")
    private Byte goodsType;

    @ApiModelProperty("商品详情")
    @NotEmpty(message = "商品详情不能为空")
    private String goodsDetail;

}
