package com.pinxixi.controller.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class HomeCarouselVO {

    @ApiModelProperty("轮播图id")
    private Integer carouselId;

    @ApiModelProperty("轮播图片地址")
    private String carouselImage;

    @ApiModelProperty("轮播图跳转链接")
    private String carouselUrl;

    @ApiModelProperty("轮播图排序")
    private String carouselSort;

    @ApiModelProperty("轮播图状态（0-已下架，1-上架中）")
    private String carouselStatus;

    @ApiModelProperty("是否已删除（0-否，1-是）")
    private Byte isDeleted;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

}
