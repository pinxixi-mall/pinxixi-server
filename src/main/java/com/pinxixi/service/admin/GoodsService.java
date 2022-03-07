package com.pinxixi.service.admin;

import com.pinxixi.controller.admin.param.GoodsQueryParam;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.Goods;

import java.util.List;

public interface GoodsService {

    /**
     * 商品列表（分页）
     * @param pageNum
     * @param pageSize
     * @param goodsQueryParam
     * @return
     */
    List<Goods> getGoodsPage(Integer pageNum, Integer pageSize, GoodsQueryParam goodsQueryParam);

    /**
     * 商品新增
     * @param goodsAddParam
     * @param adminUser
     * @return
     */
    String updateGoods(Goods goodsAddParam, AdminUser adminUser);

    Goods getGoodsDetail(Integer goodsId);

    /**
     * 商品修改
     * @param goods
     * @param adminUser
     * @return
     */
    String addGoods(Goods goods, AdminUser adminUser);
}
