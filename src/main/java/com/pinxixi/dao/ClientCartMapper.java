package com.pinxixi.dao;

import com.pinxixi.entity.ClientCart;

import java.util.List;

public interface ClientCartMapper {

    List<ClientCart> selectPageByUserId(Long userId);

    Integer insertCart(ClientCart cart);

    Integer updateCartByCartId();

}
