package com.pinxixi.service.client;

import com.pinxixi.controller.client.param.ClientOrderCreateParam;
import com.pinxixi.controller.client.param.ClientOrderUpdateParam;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.entity.Order;
import com.pinxixi.entity.OrderGoods;

import java.util.List;

public interface ClientOrderService {

    Long createOrder(ClientOrderCreateParam createParam, ClientUser user);

    Order getOrderByOrderId(Long orderId);

    List<OrderGoods> getOrderGoodsList(Long orderId);

    String updateOrder(ClientOrderUpdateParam updateParam, ClientUser user);
}
