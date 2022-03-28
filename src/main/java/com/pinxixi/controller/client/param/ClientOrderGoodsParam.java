package com.pinxixi.controller.client.param;

import lombok.Data;

@Data
public class ClientOrderGoodsParam {

    private Long goodsId;

    private String goodsName;

    private String goodsImage;

    private Float goodsPrice;

    private Integer goodsCount;

    private String goodsDesc;

}
