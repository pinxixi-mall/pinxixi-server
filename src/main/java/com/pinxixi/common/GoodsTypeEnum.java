package com.pinxixi.common;

/**
 * 商品类型枚举
 */
public enum GoodsTypeEnum {

    NORMAL("1", "普通"),

    RECOMMEND("2", "推荐");

    private String type;

    private String name;

    GoodsTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
