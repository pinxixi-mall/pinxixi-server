package com.pinxixi.dao;

import com.pinxixi.entity.Order;

import java.util.List;

public interface OrderMapper {

    List<Order> selectOrderPage();

    Integer insertOrder(Order order);

    Order selectOrderByOrderId(Long orderId);

    Order selectOrderByOrderNo(String orderNo);

    Integer updateOrder(Long orderId);

}
