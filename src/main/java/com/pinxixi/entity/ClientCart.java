package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ClientCart {

    private Long cartId;

    private Integer userId;

    private Integer goodsCount;

    private Long goodsId;

    private Byte isDeleted;

    private Date createTime;

    private Date updateTime;

}
