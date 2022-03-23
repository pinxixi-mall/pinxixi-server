package com.pinxixi.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.pinxixi.dao.OrderMapper;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.Order;
import com.pinxixi.service.admin.AdminOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> orderList(Integer pageNum, Integer pageSize, AdminUser adminUser) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.selectPage();
        return orders;
    }
}
