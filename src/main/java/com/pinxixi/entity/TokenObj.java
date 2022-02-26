package com.pinxixi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TokenObj {

    private String token;

    private Date updateTime;

    private Date expiredDate;
}
