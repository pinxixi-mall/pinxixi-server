package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 推荐商品新增接口参数
 */
@Data
public class RecommendAddParam {

    @ApiModelProperty("商品编号")
    @NotNull(message = "商品编号不能为空")
    private Long goodsId;

    @ApiModelProperty("推荐商品名称")
    @NotEmpty(message = "推荐商品名称不能为空")
    private String recommendName;

    @ApiModelProperty("推荐商品排序")
    private int recommendSort;

}
