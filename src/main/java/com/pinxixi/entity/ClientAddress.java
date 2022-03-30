package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ClientAddress {

    private Long addressId;

    private Integer userId;

    private String recipient;

    private String phone;

    private Byte isDefault;

    private String province;

    private String city;

    private String region;

    private String addressDetail;

    private Byte isDeleted;

    private Date createTime;

    private Date updateTime;

}
