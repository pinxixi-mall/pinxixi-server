package com.pinxixi.controller.client;

import com.pinxixi.common.Result;
import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.config.annotation.ClientUserArgument;
import com.pinxixi.controller.client.param.ClientCartAddParam;
import com.pinxixi.controller.client.param.ClientCartUpdateParam;
import com.pinxixi.controller.client.vo.ClientCartItemVO;
import com.pinxixi.entity.ClientCart;
import com.pinxixi.entity.ClientCartGoods;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.service.client.ClientCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Api(tags = "客户端购物车")
@RequestMapping("/client/cart")
public class ClientCartController {

    @Autowired
    private ClientCartService clientCartService;

    /**
     * 添加购物车
     * @param addParam
     * @param user
     * @return
     */
    @ApiOperation("添加购物车")
    @PostMapping
    Result addCart(@RequestBody @Valid ClientCartAddParam addParam, @ClientUserArgument ClientUser user){
        String result = clientCartService.addCart(addParam, user);
        return Result.common(result);
    }

    /**
     * 查询用户购物车列表
     * @param user
     * @return
     */
    @ApiOperation("用户购物车列表")
    @GetMapping
    Result<ClientCartItemVO> cartList(@ClientUserArgument ClientUser user) {
        List<ClientCartGoods> clientCarts = clientCartService.cartList(user);
        return Result.success(clientCarts);
    }

    /**
     * 根据购物车ids查询
     * @param cartIds
     * @return
     */
    @ApiOperation("根据购物车ids查询购物车列表")
    @GetMapping("/select")
    Result<ClientCartItemVO> cartListByIds(@RequestParam String cartIds) {
        List<String> strIds = Arrays.asList(cartIds.split(","));
        List<Long> ids = strIds.stream().map(id -> Long.parseLong(id)).collect(Collectors.toList());
        List<ClientCartGoods> clientCarts = clientCartService.cartListByIds(ids.toArray(new Long[ids.size()]));
        return Result.success(clientCarts);
    }

    /**
     * 更新购物车
     * @param updateParam
     * @return
     */
    @ApiOperation("更新购物车")
    @PutMapping
    Result updateCart(@RequestBody @Valid ClientCartUpdateParam updateParam, @ClientUserArgument ClientUser user) {
        String result = clientCartService.updateCart(updateParam, user);
        if (result.equals(ServiceResultEnum.GOODS_INVENTORY_SHORTAGE.getResult())) {
            return Result.fail(result);
        }
        return Result.common(result);
    }

    /**
     * 删除购物车项
     * @param map
     * @return
     */
    @ApiOperation("删除购物车项")
    @DeleteMapping
    Result deleteCart(@RequestBody Map<String, Long[]> map) {
        String result = clientCartService.deleteCart(map.get("cartIds"));
        return Result.common(result);
    }

}
