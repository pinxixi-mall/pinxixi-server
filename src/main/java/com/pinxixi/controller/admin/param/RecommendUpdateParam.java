package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 推荐商品修改接口参数
 */
@Data
public class RecommendUpdateParam {

    @ApiModelProperty("商品推荐编号")
    @NotNull(message = "商品推荐编号不能为空")
    private Long recommendId;

    @ApiModelProperty("商品编号")
    @NotNull(message = "商品编号不能为空")
    private Long goodsId;

    @ApiModelProperty("推荐描述")
    @NotEmpty(message = "推荐描述不能为空")
    private String recommendDesc;

    @ApiModelProperty("删除标识：0-未删除，1-已删除")
    private Byte isDeleted;

    @ApiModelProperty("推荐商品排序")
    @NotNull(message = "推荐商品排序不能为空")
    private int recommendSort;

}
