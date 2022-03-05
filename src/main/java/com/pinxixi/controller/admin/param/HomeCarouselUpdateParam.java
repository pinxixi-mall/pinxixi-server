package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class HomeCarouselUpdateParam {

    @ApiModelProperty("轮播图ID")
    @NotNull(message = "轮播图ID不能为空")
    private Integer carouselId;

    @ApiModelProperty("轮播图地址")
    private String carouselImage;

    @ApiModelProperty("轮播图跳转链接")
    private String carouselUrl;

    @ApiModelProperty("轮播图排序")
    private String carouselSort;

    @ApiModelProperty("创建人")
    private String createUser;

}
