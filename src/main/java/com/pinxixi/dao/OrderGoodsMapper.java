package com.pinxixi.dao;

import com.pinxixi.entity.Order;
import com.pinxixi.entity.OrderGoods;

import java.util.List;

public interface OrderGoodsMapper {

    Integer insertOrderGoods(OrderGoods orderGoods);

    Order selectOrderGoods(Long orderId);

    Integer insertOrderGoodsList(List<OrderGoods> orderGoodsList);
}
