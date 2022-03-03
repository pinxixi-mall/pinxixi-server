package com.pinxixi.entity;

import lombok.Data;

@Data
public class AdminUser {

    private int userId;

    private String userName;

    private String password;

    private String nickName;

    private String avatar;

    private Byte locked;

}
