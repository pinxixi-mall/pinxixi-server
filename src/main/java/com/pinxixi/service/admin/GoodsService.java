package com.pinxixi.service.admin;

import com.pinxixi.entity.Goods;

import java.util.List;

public interface GoodsService {

    /**
     * 商品列表（分页）
     * @param pageNum
     * @param pageSize
     * @param type
     * @return
     */
    List<Goods> getGoodsPage(Integer pageNum, Integer pageSize, String type);

}
