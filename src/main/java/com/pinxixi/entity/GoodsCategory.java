package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsCategory {

    private Long categoryId;

    private String categoryName;

    private Byte categoryLevel;

    private Long parentId;

    private Integer categorySort;

    private String  categoryImage;

    private Byte isDeleted;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

}
