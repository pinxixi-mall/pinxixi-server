package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Carousel {

    private int carouselId;

    private String carouselImage;

    private String carouselUrl;

    private String carouselSort;

    private String isDeleted;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

}
