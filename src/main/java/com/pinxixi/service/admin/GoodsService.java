package com.pinxixi.service.admin;

import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.controller.admin.param.GoodsAddParam;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.Goods;

import java.util.List;

public interface GoodsService {

    /**
     * 商品列表（分页）
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Goods> getGoodsPage(Integer pageNum, Integer pageSize);

    /**
     * 商品新增
     * @param goodsAddParam
     * @param adminUser
     * @return
     */
    String updateGoods(Goods goodsAddParam, AdminUser adminUser);
}
