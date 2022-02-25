package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

/**
 * 管理员token
 */
@Data
public class AdminUserToken {

    private long userId;

    private String token;

    private Date updateTime;

    private Date expiredTime;

}
