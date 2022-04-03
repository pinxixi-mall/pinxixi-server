package com.pinxixi.controller.admin;

import com.pinxixi.common.PageResult;
import com.pinxixi.common.Result;
import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.config.annotation.ClientUserArgument;
import com.pinxixi.controller.client.param.ClientOrderUpdateParam;
import com.pinxixi.controller.client.vo.ClientOrderVO;
import com.pinxixi.entity.*;
import com.pinxixi.service.admin.AdminOrderService;
import com.pinxixi.service.client.ClientAddressService;
import com.pinxixi.service.client.ClientOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "订单管理")
@RequestMapping("/admin/order-manage")
public class AdminOrderController {

    @Resource
    private AdminOrderService adminOrderService;

    @Resource
    private ClientOrderService clientOrderService;

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
        List<Order> orders = adminOrderService.orderList(pageNum, pageSize, adminUser);
        PageResult<Object> pageResult = new PageResult<>(orders);
        return Result.success(pageResult);
    }

    /**
     * 订单详情
     * @return
     */
    @ApiOperation("订单详情")
    @GetMapping("/order/{orderId}")
    Result<ClientOrderVO> getOrder(@PathVariable Long orderId) {
        return Result.success(clientOrderService.orderDetailByOrderId(orderId));
    }

    /**
     * 更新订单
     * @param updateParam
     * @return
     */
    @ApiOperation("更新订单")
    @PutMapping("/order")
    Result updateOrder(@RequestBody @Valid ClientOrderUpdateParam updateParam) {
        String result = clientOrderService.updateOrder(updateParam);
        return Result.common(result);
    }

}
