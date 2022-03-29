package com.pinxixi.service.client.impl;

import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.controller.client.param.ClientCartAddParam;
import com.pinxixi.controller.client.param.ClientCartUpdateParam;
import com.pinxixi.dao.ClientCartMapper;
import com.pinxixi.entity.ClientCart;
import com.pinxixi.entity.ClientCartGoods;
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
        //判断是否已存在相同商品
        ClientCart exitsCart = clientCartMapper.selectCartByGoodsIdAndUserId(addParam.getGoodsId(), user.getUserId());
        if (exitsCart != null) {
            //已存在，更新数量
            ClientCartUpdateParam updateParam = new ClientCartUpdateParam();
            BeanUtils.copyProperties(exitsCart, updateParam);
            //追加数量
            updateParam.setGoodsCount(addParam.getGoodsCount() + exitsCart.getGoodsCount());
            updateCart(updateParam, user);
            return PinXiXiUtils.genSqlResultByRows(1);
        }
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
    public List<ClientCartGoods> cartList(ClientUser user) {
        List<ClientCartGoods> clientCarts = clientCartMapper.selectCartGoodsByUserId(user.getUserId());
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
        //TODO 应取tb_goods表的库存来判断
        ClientCartGoods cartItem = clientCartMapper.selectCartGoodsByCartId(cartId);
        if (cartItem.getGoodsStock() < updateParam.getGoodsCount()) {
            // 库存不足
            return ServiceResultEnum.GOODS_INVENTORY_SHORTAGE.getResult();
        }
        updateParam.setUserId(user.getUserId());
        Integer rows = clientCartMapper.updateCart(updateParam);
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
    public List<ClientCartGoods> cartListByIds(Long[] ids, ClientUser user) {
        List<ClientCartGoods> clientCarts = clientCartMapper.selectCartGoodsByCartIds(ids, user.getUserId());
        return clientCarts;
    }
}
