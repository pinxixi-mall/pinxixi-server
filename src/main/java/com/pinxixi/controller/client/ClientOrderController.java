package com.pinxixi.controller.client;

import com.pinxixi.common.Result;
import com.pinxixi.config.annotation.ClientUserArgument;
import com.pinxixi.controller.client.param.ClientOrderCreateParam;
import com.pinxixi.controller.client.vo.ClientOrderVO;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.entity.Order;
import com.pinxixi.entity.OrderGoods;
import com.pinxixi.service.admin.AdminOrderService;
import com.pinxixi.service.client.ClientOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "客户端订单")
@RequestMapping("/client/order")
public class ClientOrderController {

    @Autowired
    private ClientOrderService clientOrderService;

    /**
     * 订单生成
     * @param createParam
     * @return
     */
    @ApiOperation("用户订单生成")
    @PostMapping
    Result createOrder(@RequestBody @Valid ClientOrderCreateParam createParam, @ClientUserArgument ClientUser user) {
        Long orderId = clientOrderService.createOrder(createParam, user);
        Map result = new HashMap<String, Long>();
        result.put("orderId", orderId);
        return Result.success(result);
    }

    /**
     * 根据订单ID查订单详情
     * @param orderId
     * @return
     */
    @ApiOperation("订单详情")
    @GetMapping("/{orderId}")
    Result<ClientOrderVO> getOrder(@PathVariable Long orderId) {
        Order order = clientOrderService.getOrderByOrderId(orderId);
        List<OrderGoods> orderGoodsList = clientOrderService.getOrderGoodsList(orderId);
        ClientOrderVO clientOrderVO = new ClientOrderVO();
        BeanUtils.copyProperties(order, clientOrderVO);
        clientOrderVO.setGoodsList(orderGoodsList);
        return Result.success(clientOrderVO);
    }

    /**
     * 根据订单ID获取订单商品
     * @param orderId
     * @return
     */
    @ApiOperation("获取订单商品")
    @GetMapping("/goods")
    Result getOrderGoods(@RequestParam(value = "orderId") Long orderId) {

        return Result.success();
    }

}
