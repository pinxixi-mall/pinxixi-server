package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 新增推荐商品接口参数
 */
@Data
public class HomeCarouselAddParam {

    @ApiModelProperty("轮播图地址")
    @NotEmpty(message = "轮播图地址不能为空")
    private String carouselImage;

    @ApiModelProperty("轮播图跳转链接")
    private String carouselUrl;

    @ApiModelProperty("轮播图排序")
    private String carouselSort;

    @ApiModelProperty("创建人")
    private String createUser;

}
