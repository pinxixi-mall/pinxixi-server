package com.pinxixi.dao;

import com.pinxixi.controller.client.param.ClientCartUpdateParam;
import com.pinxixi.entity.ClientCart;

import java.util.List;

public interface ClientCartMapper {

    List<ClientCart> selectPageByUserId(Long userId);

    Integer insertCart(ClientCart cart);

    Integer updateCartByCartId(ClientCartUpdateParam updateParam);

    ClientCart selectCartByCartId(Long cartId);

    Integer deleteCartByCartIds(Integer[] ids);
}
