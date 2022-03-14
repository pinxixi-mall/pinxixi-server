package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private Long orderId;

    private String orderNo;

    private Integer userId;

    private Float orderPrice;

    private Byte orderStatus;

    private Byte paymentStatus;

    private Byte paymentType;

    private Date paymentTime;

    private Date createTime;

    private Date updateTime;

}
