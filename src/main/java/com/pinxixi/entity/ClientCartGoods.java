package com.pinxixi.entity;

import lombok.Data;

import java.util.Date;

/**
 * 购物车&商品联表实体
 */
@Data
public class ClientCartGoods {

    private Long cartId;

    private Integer userId;

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

    //关联tb_goods的商品库存
    private Integer goodsStock;

    private Byte isDeleted;

}
