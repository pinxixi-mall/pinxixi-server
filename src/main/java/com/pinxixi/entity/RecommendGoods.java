package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class RecommendGoods {

    private Long recommendId;

    private Long goodsId;

    private String recommendName;

    private int recommendSort;

    private Byte isDeleted;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

}
