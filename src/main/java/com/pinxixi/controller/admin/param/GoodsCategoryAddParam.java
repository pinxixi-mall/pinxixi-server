package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品分类新增接口参数
 */
@Data
public class GoodsCategoryAddParam {

    @ApiModelProperty("分类级别")
    @NotNull(message = "分类级别不能为空")
    private Byte categoryLevel;

    @ApiModelProperty("分类父级ID")
    @NotNull(message = "分类父级ID不能为空")
    private Long parentId;

    @ApiModelProperty("分类名称")
    @NotEmpty(message = "分类名称不能为空")
    private String categoryName;

    @ApiModelProperty("分类图标")
    @NotEmpty(message = "分类图标不能为空")
    private String categoryImage;

    @ApiModelProperty("分类排序")
    private Integer categorySort;

}
