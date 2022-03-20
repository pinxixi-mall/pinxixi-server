package com.pinxixi.controller.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GoodsCategoryTreeVO {

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

    @ApiModelProperty("分类图标")
    private String categoryImage;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("分类子集")
    private List<GoodsCategoryTreeVO> children;

}
