package com.pinxixi.service.client.impl;

import com.pinxixi.controller.client.param.ClientCartAddParam;
import com.pinxixi.dao.ClientCartMapper;
import com.pinxixi.entity.ClientCart;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.service.client.ClientCartService;
import com.pinxixi.utils.PinXiXiUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientCartServiceImpl implements ClientCartService {

    @Resource
    private ClientCartMapper clientCartMapper;

    @Override
    public String addCart(ClientCartAddParam addParam, ClientUser user) {
        ClientCart clientCart = new ClientCart();
        BeanUtils.copyProperties(addParam, clientCart);
        clientCart.setUserId(user.getUserId());
        Integer rows = clientCartMapper.insertCart(clientCart);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    @Override
    public List<ClientCart> cartList(ClientUser user) {
        List<ClientCart> clientCarts = clientCartMapper.selectPageByUserId(user.getUserId());
        return clientCarts;
    }
}
