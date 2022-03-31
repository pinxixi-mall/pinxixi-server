package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private Long orderId;

    private String orderNo;

    private Integer userId;

    private Long addressId;

    private Float orderPrice;

    private Float orderCoupon;

    private Byte orderStatus;

    private Byte paymentStatus;

    private Byte paymentType;

    private Date paymentTime;

    private Byte isDeleted;

    private Date createTime;

    private Date updateTime;

}
