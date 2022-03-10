package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 商品分类查询接口参数
 */
@Data
public class GoodsCategoryQueryParam {

    @ApiModelProperty("页码")
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码不能小于1")
    private Integer pageNum;

    @ApiModelProperty("每页条数")
    @NotNull(message = "每页条数不能为空")
    private Integer pageSize;

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("分类名称")
    private String categoryName;

}
