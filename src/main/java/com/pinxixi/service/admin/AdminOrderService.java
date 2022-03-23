package com.pinxixi.service.admin;

import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.Order;

import java.util.List;

public interface AdminOrderService {

    List<Order> orderList(Integer pageNum, Integer pageSize, AdminUser adminUser);

}
