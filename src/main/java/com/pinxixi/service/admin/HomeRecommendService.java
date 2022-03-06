package com.pinxixi.service.admin;

import com.pinxixi.controller.admin.param.GoodsAddParam;
import com.pinxixi.entity.Goods;

import java.util.List;

public interface HomeRecommendService {

    /**
     * 商品列表（分页）
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Goods> getGoodsPage(Integer pageNum, Integer pageSize);

    /**
     * 商品新增
     * @param goods
     * @return
     */
    String updateGoods(Goods goods);
}
