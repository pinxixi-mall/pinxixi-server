package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class HomeCarousel {

    private int carouselId;

    private String carouselImage;

    private String carouselUrl;

    private String carouselSort;

    private String carouselStatus;

    private String isDeleted;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

}
