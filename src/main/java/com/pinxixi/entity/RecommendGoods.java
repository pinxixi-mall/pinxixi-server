package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class RecommendGoods {

    private Long recommendId;

    private Long goodsId;

    private String goodsName;

    private String goodsImage;

    private Float goodsPrice;

    private String recommendDesc;

    private int recommendSort;

    private Byte isDeleted;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

}
