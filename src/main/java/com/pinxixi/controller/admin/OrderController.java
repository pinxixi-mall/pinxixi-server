package com.pinxixi.controller.admin;

import com.pinxixi.common.PageResult;
import com.pinxixi.common.Result;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.Order;
import com.pinxixi.service.admin.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "订单管理")
@RequestMapping("/order-manage")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @param pageNum
     * @param pageSize
     * @param adminUser
     * @return
     */
    @ApiOperation("订单列表")
    @GetMapping("/order/list")
    public Result<PageResult<Order>> orderList(@RequestParam Integer pageNum,
                                               @RequestParam Integer pageSize,
                                               @AdminUserArgument AdminUser adminUser) {
        List<Order> orders = orderService.orderList(pageNum, pageSize, adminUser);
        PageResult<Object> pageResult = new PageResult<>(orders);
        return Result.success(pageResult);
    }

    @ApiOperation("生成订单")
    @PostMapping("/order/create")
    public Result createOrder() {
        return Result.success();
    }

}
