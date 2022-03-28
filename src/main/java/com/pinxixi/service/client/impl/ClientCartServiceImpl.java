package com.pinxixi.service.client.impl;

import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.controller.client.param.ClientCartAddParam;
import com.pinxixi.controller.client.param.ClientCartUpdateParam;
import com.pinxixi.dao.ClientCartMapper;
import com.pinxixi.entity.ClientCart;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.service.client.ClientCartService;
import com.pinxixi.utils.PinXiXiUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientCartServiceImpl implements ClientCartService {

    @Resource
    private ClientCartMapper clientCartMapper;

    /**
     * 添加购物车
     * @param addParam
     * @param user
     * @return
     */
    @Override
    public String addCart(ClientCartAddParam addParam, ClientUser user) {
        ClientCart clientCart = new ClientCart();
        BeanUtils.copyProperties(addParam, clientCart);
        clientCart.setUserId(user.getUserId());
        Integer rows = clientCartMapper.insertCart(clientCart);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 购物车列表
     * @param user
     * @return
     */
    @Override
    public List<ClientCart> cartList(ClientUser user) {
        List<ClientCart> clientCarts = clientCartMapper.selectPageByUserId(user.getUserId());
        return clientCarts;
    }

    /**
     * 更新购物车
     * @param updateParam
     * @param user
     * @return
     */
    @Override
    public String updateCart(ClientCartUpdateParam updateParam, ClientUser user) {
        Long cartId = updateParam.getCartId();
        ClientCart cartItem = clientCartMapper.selectCartByCartId(cartId);
        if (cartItem.getGoodsStock() < updateParam.getGoodsCount()) {
            // 库存不足
            return ServiceResultEnum.GOODS_INVENTORY_SHORTAGE.getResult();
        }
        updateParam.setUserId(user.getUserId());
        Integer rows = clientCartMapper.updateCartByCartId(updateParam);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 删除购物车项
     * @param ids
     * @return
     */
    @Override
    public String deleteCart(Long[] ids) {
        Integer rows = clientCartMapper.deleteCartByCartIds(ids);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 根据ids查询购物车
     * @param ids
     * @return
     */
    @Override
    public List<ClientCart> cartListByIds(Long[] ids) {
        List<ClientCart> clientCarts = clientCartMapper.selectCartByCartIds(ids);
        return clientCarts;
    }
}
