package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品分类修改接口参数
 */
@Data
public class GoodsCategoryUpdateParam {

    @ApiModelProperty("分类ID")
    @NotNull(message = "分类ID不能为空")
    private Long categoryId;

    @ApiModelProperty("分类名称")
    @NotEmpty(message = "分类名称不能为空")
    private String categoryName;

    @ApiModelProperty("分类排序")
    private Integer categorySort;

    @ApiModelProperty("删除标识：0-未删除，1-已删除")
    private Byte isDeleted;

}
