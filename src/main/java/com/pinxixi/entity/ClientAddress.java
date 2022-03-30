package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ClientAddress {

    private Long addressId;

    private Integer userId;

    private String name;

    private String tel;

    private Byte isDefault;

    private String province;

    private String city;

    private String county;

    private String addressDetail;

    private Byte isDeleted;

    private Date createTime;

    private Date updateTime;

}
