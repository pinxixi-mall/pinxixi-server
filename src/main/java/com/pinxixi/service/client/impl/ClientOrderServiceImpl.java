package com.pinxixi.service.client.impl;

import cn.hutool.core.util.RandomUtil;
import com.pinxixi.common.GoodsEnum;
import com.pinxixi.common.HttpStatusEnum;
import com.pinxixi.config.PinXiXiException;
import com.pinxixi.controller.client.param.ClientOrderCreateParam;
import com.pinxixi.dao.ClientCartMapper;
import com.pinxixi.dao.GoodsMapper;
import com.pinxixi.dao.OrderMapper;
import com.pinxixi.entity.ClientCart;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.entity.Goods;
import com.pinxixi.entity.Order;
import com.pinxixi.service.client.ClientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientOrderServiceImpl implements ClientOrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private ClientCartMapper clientCartMapper;

    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 订单生成
     * @param createParam
     * @param user
     * @return
     */
    @Override
    public String createOrder(ClientOrderCreateParam createParam, ClientUser user) {
        //订单购物车项id数组
        Long[] cartIds = createParam.getCartIds();
        //订单购物车
        List<ClientCart> carts = clientCartMapper.selectCartByCartIds(cartIds);
        //订单购物车商品
        List<Long> goodsIds = carts.stream().map(ClientCart::getGoodsId).collect(Collectors.toList());
        List<Goods> goodsList = goodsMapper.selectGoodsByIds(goodsIds);
        //已下架商品
        List<Goods> offShelfGoods = goodsList.stream().filter(goods -> goods.getGoodsStatus() == GoodsEnum.GOODS_OFF_SHELF.getCode()).collect(Collectors.toList());
        if (offShelfGoods != null) {
            PinXiXiException.error(HttpStatusEnum.FAIL.getCode(), offShelfGoods.get(0).getGoodsName() + "已下架");
        }
        //判断库存
        for (ClientCart cart : carts) {
            //购物车商品
            Goods cartGoods = goodsMapper.selectGoods(cart.getGoodsId());
            //商品表商品
            List<Goods> collect = goodsList.stream().filter(goods -> goods.getGoodsId().equals(cartGoods.getGoodsId())).collect(Collectors.toList());
            if (collect != null) {
                if (cartGoods.getGoodsStock() > collect.get(0).getGoodsStock()) {
                    PinXiXiException.error(HttpStatusEnum.FAIL.getCode(), cartGoods.getGoodsName() + "库存不足");
                }
            }
        }

        //生成订单号
        String orderNo = System.currentTimeMillis() + RandomUtil.randomNumbers(4);
        //计算订单总额


        //将订单购物车商品存在订单商品表


        return null;
    }

}
