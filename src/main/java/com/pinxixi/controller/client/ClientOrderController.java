package com.pinxixi.controller.client;

import com.pinxixi.common.Result;
import com.pinxixi.config.annotation.ClientUserArgument;
import com.pinxixi.controller.client.param.ClientOrderCreateParam;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.service.admin.AdminOrderService;
import com.pinxixi.service.client.ClientOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
        String result = clientOrderService.createOrder(createParam, user);
        return Result.common(result);
    }

}
