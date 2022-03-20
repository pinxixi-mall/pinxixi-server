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
    @Min(value = 1, message = "每页条数不能小于1")
    private Integer pageSize;

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("分类父级id")
    private Long parentId;

    @ApiModelProperty("分类级别")
    private Long categoryLevel;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("树形分类开始级别：1-一级，2-二级，3-三级")
    private Long startLevel;

}
