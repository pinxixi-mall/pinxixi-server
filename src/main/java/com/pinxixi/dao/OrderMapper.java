package com.pinxixi.dao;

import com.pinxixi.entity.Order;

import java.util.List;

public interface OrderMapper {

    List<Order> selectOrderPage();

    Integer insertOrder(Order order);

    Order selectOrder(Long orderId);

    Integer updateOrder(Long orderId);

}
