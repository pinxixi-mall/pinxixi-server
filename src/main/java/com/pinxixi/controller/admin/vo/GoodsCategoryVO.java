package com.pinxixi.controller.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsCategoryVO {

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("分类级别（1-一级，2-二级，3-三级）")
    private Byte categoryLevel;

    @ApiModelProperty("父级id")
    private Long parentId;

    @ApiModelProperty("分类排序")
    private Integer categorySort;

}
