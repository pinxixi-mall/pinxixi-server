package com.pinxixi.service.client;

import com.pinxixi.controller.client.param.ClientCartAddParam;
import com.pinxixi.controller.client.param.ClientCartUpdateParam;
import com.pinxixi.entity.ClientCart;
import com.pinxixi.entity.ClientUser;

import java.util.List;

public interface ClientCartService {

    String addCart(ClientCartAddParam addParam, ClientUser user);

    List<ClientCart> cartList(ClientUser user);

    String updateCart(ClientCartUpdateParam updateParam, ClientUser user);

    String deleteCart(Long[] ids);

    List<ClientCart> cartListByIds(Long[] ids);
}
