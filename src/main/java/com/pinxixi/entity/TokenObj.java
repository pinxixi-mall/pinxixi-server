package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TokenObj {

    private String token;

    private Date updateTime;

    private Date expiredDate;
}
