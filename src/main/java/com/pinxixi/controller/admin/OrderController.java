package com.pinxixi.controller.admin;

import com.pinxixi.common.Result;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.entity.AdminUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "订单管理")
@RequestMapping("/order-manage")
public class OrderController {

    /**
     * 订单列表
     * @param adminUser
     * @return
     */
    @ApiOperation("订单列表")
    @GetMapping("/order/list")
    public Result orderList(@AdminUserArgument AdminUser adminUser) {
        return Result.common("");
    }

}
