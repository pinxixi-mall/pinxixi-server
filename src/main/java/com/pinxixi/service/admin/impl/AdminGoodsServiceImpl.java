package com.pinxixi.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.pinxixi.controller.admin.param.GoodsQueryParam;
import com.pinxixi.controller.admin.param.GoodsStatusUpdateParam;
import com.pinxixi.dao.GoodsMapper;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.Goods;
import com.pinxixi.service.admin.AdminGoodsService;
import com.pinxixi.utils.PinXiXiUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AdminGoodsServiceImpl implements AdminGoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 商品分页列表
     * @param goodsQueryParam
     * @return
     */
    @Override
    public List<Goods> getGoodsPage(GoodsQueryParam goodsQueryParam) {
        PageHelper.startPage(goodsQueryParam.getPageNum(), goodsQueryParam.getPageSize());
        List<Goods> goods = goodsMapper.selectPage(goodsQueryParam);
        return goods;
    }

    /**
     * 商品新增
     * @param goods
     * @param adminUser
     * @return
     */
    @Override
    public String addGoods(Goods goods, AdminUser adminUser) {
        goods.setCreateUser(adminUser.getUserId());
        goods.setCreateTime(new Date());
        int rows = goodsMapper.insertGoods(goods);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 商品修改
     * @param goods
     * @param adminUser
     * @return
     */
    @Override
    public String updateGoods(Goods goods, AdminUser adminUser) {
        goods.setUpdateUser(adminUser.getUserId());
        goods.setUpdateTime(new Date());
        int rows = goodsMapper.updateGoods(goods);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 上下架
     * @param updateParam
     * @param adminUser
     * @return
     */
    @Override
    public String updateStatus(GoodsStatusUpdateParam updateParam, AdminUser adminUser) {
        Goods goods = new Goods();
        goods.setUpdateUser(adminUser.getUserId());
        goods.setUpdateTime(new Date());
        BeanUtils.copyProperties(updateParam, goods);
        int rows = goodsMapper.updateGoods(goods);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 删除商品
     * @param goodsId
     * @param adminUser
     * @return
     */
    @Override
    public String deleteGoods(Long goodsId, AdminUser adminUser) {
        Goods goods = new Goods();
        goods.setUpdateUser(adminUser.getUserId());
        goods.setUpdateTime(new Date());
        goods.setGoodsId(goodsId);
        goods.setIsDeleted((byte) 1);
        int rows = goodsMapper.updateGoods(goods);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 商品详情
     * @param goodsId
     * @return
     */
    @Override
    public Goods getGoodsDetail(Integer goodsId) {
        Goods goods = goodsMapper.selectGoods(goodsId);
        return goods;
    }


}
