package com.pinxixi.dao;

import com.pinxixi.controller.client.param.ClientCartUpdateParam;
import com.pinxixi.entity.ClientCart;
import com.pinxixi.entity.ClientCartGoods;

import java.util.List;

public interface ClientCartMapper {

    List<ClientCartGoods> selectPageByUserId(Integer userId);

    Integer insertCart(ClientCart cart);

    Integer updateCartByCartId(ClientCartUpdateParam updateParam);

    ClientCartGoods selectCartGoodsByCartId(Long cartId);

    Integer deleteCartByCartIds(Long[] ids);

    List<ClientCartGoods> selectCartGoodsByCartIds(Long[] ids);

    List<ClientCart> selectCartByCartIds(Long[] ids);
}
