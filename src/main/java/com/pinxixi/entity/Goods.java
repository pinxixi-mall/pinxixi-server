package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Goods {

    private Long goodsId;

    private String goodsName;

    private String goodsImage;

    private Long goodsCategoryId;

    private String goodsDesc;

    private Float goodsPrice;

    private Integer goodsStock;

    private Byte goodsStatus;

    private Byte goodsType;

    private String goodsDetail;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

}
