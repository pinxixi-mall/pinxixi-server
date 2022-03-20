package com.pinxixi.controller.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

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

    @ApiModelProperty("分类图标")
    private String categoryImage;

    @ApiModelProperty("分类排序")
    private Integer categorySort;

    @ApiModelProperty("创建时间")
    private Date createTime;

}
