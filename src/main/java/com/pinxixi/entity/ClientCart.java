package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ClientCart {

    private Long cartId;

    private Long userId;

    private Integer goodsCount;

    private Long goodsId;

    //关联tb_goods的商品图片
    private String goodsImage;

    //关联tb_goods的商品价格
    private Integer goodsPrice;

    //关联tb_goods的商品名称
    private String goodsName;

    //关联tb_goods的商品描述
    private String goodsDesc;

    private Byte isDeleted;

    private Date createTime;

    private Date updateTime;

}
