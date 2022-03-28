package com.pinxixi.service.client;

import com.pinxixi.controller.client.param.ClientOrderCreateParam;
import com.pinxixi.entity.ClientUser;

public interface ClientOrderService {

    String createOrder(ClientOrderCreateParam createParam, ClientUser user);

}
