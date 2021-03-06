package com.pinxixi.entity;

import lombok.Data;

@Data
public class AdminUser {

    private Integer userId;

    private String userName;

    private String password;

    private String nickName;

    private String avatar;

    private String phone;

    private String email;

    private Byte locked;

}
