package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ClientCart {

    private Long cartId;

    private Long userId;

    private Long goodsId;

    private Integer goodsCount;

    private Byte isDeleted;

    private Date createTime;

    private Date updateTime;

}
