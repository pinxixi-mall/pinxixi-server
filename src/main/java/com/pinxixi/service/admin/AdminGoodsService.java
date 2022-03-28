package com.pinxixi.service.admin;

import com.pinxixi.controller.admin.param.GoodsQueryParam;
import com.pinxixi.controller.admin.param.GoodsStatusUpdateParam;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.Goods;

import java.util.List;

public interface AdminGoodsService {

    /**
     * 商品列表（分页）
     * @param goodsQueryParam
     * @return
     */
    List<Goods> getGoodsPage(GoodsQueryParam goodsQueryParam);

    /**
     * 商品新增
     * @param goods
     * @param adminUser
     * @return
     */
    String updateGoods(Goods goods, AdminUser adminUser);

    /**
     * 商品详情
     * @param goodsId
     * @return
     */
    Goods getGoodsDetail(Long goodsId);

    /**
     * 商品修改
     * @param goods
     * @param adminUser
     * @return
     */
    String addGoods(Goods goods, AdminUser adminUser);

    /**
     * 上下架
     * @param updateParam
     * @param adminUser
     * @return
     */
    String updateStatus(GoodsStatusUpdateParam updateParam, AdminUser adminUser);

    /**
     * 删除商品
     * @param goodsId
     * @param adminUser
     * @return
     */
    String deleteGoods(Long goodsId, AdminUser adminUser);

}
