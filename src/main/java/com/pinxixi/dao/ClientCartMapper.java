package com.pinxixi.dao;

import com.pinxixi.controller.client.param.ClientCartUpdateParam;
import com.pinxixi.entity.ClientCart;
import com.pinxixi.entity.ClientCartGoods;

import java.util.List;

public interface ClientCartMapper {

    /**
     * 根据用户ID查询
     * @param userId
     * @return
     */
    List<ClientCartGoods> selectCartGoodsByUserId(Integer userId);

    /**
     * 根据购物车ID列表查询（联表）
     * @param ids
     * @return
     */
    List<ClientCartGoods> selectCartGoodsByCartIds(Long[] ids, Integer userId);

    /**
     * 根据购物车ID列表查询
     * @param ids
     * @return
     */
    List<ClientCart> selectCartByCartIds(Long[] ids);

    /**
     * 根据购物车ID查询
     * @param cartId
     * @return
     */
    ClientCartGoods selectCartGoodsByCartId(Long cartId);

    /**
     * 根据用户ID和商品ID查询
     * @param goodsId
     * @param userId
     * @return
     */
    ClientCart selectCartByGoodsIdAndUserId(Long goodsId, Integer userId);

    /**
     * 新增购物车
     * @param cart
     * @return
     */
    Integer insertCart(ClientCart cart);

    /**
     * 更新购物车
     * @param updateParam
     * @return
     */
    Integer updateCart(ClientCartUpdateParam updateParam);

    /**
     * 删除购物车
     * @param ids
     * @return
     */
    Integer deleteCartByCartIds(Long[] ids);

}
