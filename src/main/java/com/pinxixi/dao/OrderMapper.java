package com.pinxixi.dao;

import com.pinxixi.entity.Order;

import java.util.List;

public interface OrderMapper {

    List<Order> selectOrderPage();

    List<Order> selectOrderAll();

    Integer insertOrder(Order order);

    Order selectOrderByOrderId(Long orderId);

    Order selectOrderByOrderNo(String orderNo);

    Integer updateOrderByOrderId(Long orderId);

    Integer updateOrder(Order order);
}
