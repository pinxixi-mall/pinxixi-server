package com.pinxixi.controller.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CarouselVo {

    @ApiModelProperty("轮播图片地址")
    private String carouselImage;

    @ApiModelProperty("轮播图跳转链接")
    private String carouselUrl;

}
