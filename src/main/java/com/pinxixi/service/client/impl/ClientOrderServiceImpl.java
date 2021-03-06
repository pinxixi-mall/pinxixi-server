package com.pinxixi.service.client.impl;

import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinxixi.common.*;
import com.pinxixi.config.PinXiXiException;
import com.pinxixi.controller.client.param.ClientOrderCreateParam;
import com.pinxixi.controller.client.param.ClientOrderUpdateParam;
import com.pinxixi.controller.client.param.ClientOrdersQueryParam;
import com.pinxixi.controller.client.vo.ClientAddressVO;
import com.pinxixi.controller.client.vo.ClientOrderVO;
import com.pinxixi.dao.ClientCartMapper;
import com.pinxixi.dao.GoodsMapper;
import com.pinxixi.dao.OrderGoodsMapper;
import com.pinxixi.dao.OrderMapper;
import com.pinxixi.entity.*;
import com.pinxixi.service.client.ClientAddressService;
import com.pinxixi.service.client.ClientOrderService;
import com.pinxixi.utils.PinXiXiUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class ClientOrderServiceImpl implements ClientOrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private ClientCartMapper clientCartMapper;

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private OrderGoodsMapper orderGoodsMapper;

    @Resource
    private ClientAddressService clientAddressService;

    /**
     * 订单生成
     * @param createParam
     * @param user
     * @return
     */
    @Override
    public Long createOrder(ClientOrderCreateParam createParam, ClientUser user) {
        //订单购物车项id数组
        Long[] cartIds = createParam.getCartIds();
        //订单购物车
        List<ClientCart> carts = clientCartMapper.selectCartsByCartIds(cartIds);
        //订单购物车商品
        List<Long> goodsIds = carts.stream().map(ClientCart::getGoodsId).collect(Collectors.toList());
        List<Goods> goodsList = goodsMapper.selectGoodsByIds(goodsIds);

        //判断是否有已下架商品
        List<Goods> offShelfGoods = goodsList.stream().filter(goods -> goods.getGoodsStatus() == GoodsEnum.GOODS_OFF_SHELF.getCode()).collect(Collectors.toList());
        if (offShelfGoods.size() > 0) {
            PinXiXiException.error(HttpStatusEnum.FAIL.getCode(), offShelfGoods.get(0).getGoodsName() + "已下架");
        }

        //订单总额
        Float totalPrice = 0f;

        for (ClientCart cart : carts) {
            //购物车商品
            Goods cartGoods = goodsMapper.selectGoods(cart.getGoodsId());
            //商品表商品
            List<Goods> collect = goodsList.stream().filter(goods -> goods.getGoodsId().equals(cartGoods.getGoodsId())).collect(Collectors.toList());
            if (collect.size() > 0) {
                //判断库存
                if (cartGoods.getGoodsStock() > collect.get(0).getGoodsStock()) {
                    PinXiXiException.error(HttpStatusEnum.FAIL.getCode(), cartGoods.getGoodsName() + "库存不足");
                }
            }

            //计算总金额
            List<Goods> goodsInCart = goodsList.stream().filter(goods -> goods.getGoodsId().equals(cart.getGoodsId())).collect(Collectors.toList());
            totalPrice += cart.getGoodsCount() * goodsInCart.get(0).getGoodsPrice();
        }
        //减去优惠金额
        totalPrice -= createParam.getOrderCoupon();

        Order orderSaved = null;
        //删除购物车
        //TODO 使用事务
        if(clientCartMapper.deleteCartByCartIds(cartIds) > 0) {
            //生成订单号
            String orderNo = System.currentTimeMillis() + RandomUtil.randomNumbers(4);
            //保存到订单表
            Order order = new Order();
            order.setOrderNo(orderNo);
            order.setOrderPrice(totalPrice);
            order.setOrderCoupon(createParam.getOrderCoupon());
            order.setAddressId(createParam.getAddressId());
            order.setUserId(user.getUserId());
            if (orderMapper.insertOrder(order) <= 0) {
                PinXiXiException.fail();
            }

            //取出刚存的订单
            orderSaved = orderMapper.selectOrderByOrderNo(orderNo);
            List<OrderGoods> orderGoodsList = new ArrayList<>();
            //关联订单商品
            for (ClientCart cart : carts) {
                List<Goods> goodsItem = goodsList.stream().filter(goods -> goods.getGoodsId().equals(cart.getGoodsId())).collect(Collectors.toList());
                OrderGoods orderGoods = new OrderGoods();
                BeanUtils.copyProperties(goodsItem.get(0), orderGoods);
                BeanUtils.copyProperties(cart, orderGoods);
                orderGoods.setOrderId(orderSaved.getOrderId());
                orderGoodsList.add(orderGoods);
            }
            //保存到订单商品表
            if(orderGoodsMapper.insertOrderGoodsList(orderGoodsList) <= 0) {
                PinXiXiException.fail();
            }
        }

        return orderSaved.getOrderId();
    }

    /**
     * 订单详情
     * @param orderId
     * @return
     */
    @Override
    public Order getOrderByOrderId(Long orderId) {
        Order order = orderMapper.selectOrderByOrderId(orderId);
        return order;
    }

    /**
     * 订单商品
     * @param orderId
     * @return
     */
    @Override
    public List<OrderGoods> getOrderGoodsList(Long orderId) {
        List<OrderGoods> orderGoodsList = orderGoodsMapper.selectByOrderId(orderId);
        return orderGoodsList;
    }

    /**
     * 更新订单
     * @param updateParam
     * @return
     */
    @Override
    public String updateOrder(ClientOrderUpdateParam updateParam) {
        Order order = new Order();
        BeanUtils.copyProperties(updateParam, order);
        if (updateParam.getPaymentStatus() != null && updateParam.getPaymentStatus() != 0) {
            order.setPaymentTime(new Date());
        }
        int rows = orderMapper.updateOrder(order);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 查询订单列表
     * @param queryParam
     * @return
     */
    @Override
    public PageResult getOrders(@Valid ClientOrdersQueryParam queryParam) {
        if (queryParam.getOrderStatus() == 99) {
            //99查全部
            queryParam.setOrderStatus(null);
        }
        PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
        //所有订单
        List<Order> orderList = orderMapper.selectOrdersByStatus(queryParam);
        List<ClientOrderVO> clientOrderVOS = new ArrayList<>();

        if (orderList.size() > 0) {
            clientOrderVOS = PinXiXiUtils.copyList(orderList, ClientOrderVO.class);
            //所有订单id
            List<Long> orderIds = orderList.stream().map(Order::getOrderId).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(orderIds)) {
                //所有订单关联的商品
                List<OrderGoods> orderGoodsList = orderGoodsMapper.selectByOrderIds(orderIds);
                //按订单id分组
                Map<Long, List<OrderGoods>> orderGoodsListMap = orderGoodsList.stream().collect(groupingBy(OrderGoods::getOrderId));
                for (ClientOrderVO clientOrderVO : clientOrderVOS) {
                    if (orderGoodsListMap.containsKey(clientOrderVO.getOrderId())) {
                        List<OrderGoods> goodsList = orderGoodsListMap.get(clientOrderVO.getOrderId());
                        clientOrderVO.setGoodsList(goodsList);
                    }
                }

            }
        }
        //以startPage后查询的list构建分页
        PageResult<ClientOrderVO> pageResult = new PageResult<>(orderList);
        //用添加了goodsList的订单list覆盖原分页结果里的list
        pageResult.setList(clientOrderVOS);
        return pageResult;
    }

    /**
     * 订单详情（带商品信息+地址信息）
     * @param orderId
     * @return
     */
    @Override
    public ClientOrderVO orderDetailByOrderId(Long orderId) {
        Order order = getOrderByOrderId(orderId);
        if (order == null) {
            PinXiXiException.error(501, ServiceResultEnum.ORDER_NOT_EXIST.getResult());
        }
        List<OrderGoods> orderGoodsList = getOrderGoodsList(orderId);
        ClientAddress address = clientAddressService.getAddressById(order.getAddressId());
        ClientAddressVO clientAddressVO = new ClientAddressVO();
        BeanUtils.copyProperties(address, clientAddressVO);
        ClientOrderVO clientOrderVO = new ClientOrderVO();
        BeanUtils.copyProperties(order, clientOrderVO);
        clientOrderVO.setAddress(clientAddressVO);
        clientOrderVO.setGoodsList(orderGoodsList);
        return clientOrderVO;
    }

}
