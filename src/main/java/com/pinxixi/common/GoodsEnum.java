package com.pinxixi.common;

/**
 * 商品类型枚举
 */
public enum GoodsEnum {

    NORMAL_GOOD(1, "普通商品"),

    RECOMMEND_GOOD(2, "推荐商品"),

    CAROUSEL_ON_SHELF(1, "轮播图已上架"),

    CAROUSEL_OFF_SHELF(0, "轮播图已下架");

    private int code;

    private String name;

    GoodsEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
