package com.pinxixi.service.client;

import com.pinxixi.common.PageResult;
import com.pinxixi.controller.client.param.ClientOrderCreateParam;
import com.pinxixi.controller.client.param.ClientOrderUpdateParam;
import com.pinxixi.controller.client.param.ClientOrdersQueryParam;
import com.pinxixi.controller.client.vo.ClientOrderVO;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.entity.Order;
import com.pinxixi.entity.OrderGoods;

import javax.validation.Valid;
import java.util.List;

public interface ClientOrderService {

    Long createOrder(ClientOrderCreateParam createParam, ClientUser user);

    Order getOrderByOrderId(Long orderId);

    List<OrderGoods> getOrderGoodsList(Long orderId);

    String updateOrder(ClientOrderUpdateParam updateParam);

    PageResult getOrders(@Valid ClientOrdersQueryParam queryParam);

    ClientOrderVO orderDetailByOrderId(Long orderId);
}
