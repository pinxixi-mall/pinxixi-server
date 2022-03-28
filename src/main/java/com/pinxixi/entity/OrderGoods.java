package com.pinxixi.entity;

import lombok.Data;

/**
 * 订单商品
 */
@Data
public class OrderGoods {

    private Long orderGoodsId;

    private Long orderId;

    private Long goodsId;

    private String goodsName;

    private String goodsImage;

    private Float goodsPrice;

    private Integer goodsCount;

    private String goodsDesc;

}
