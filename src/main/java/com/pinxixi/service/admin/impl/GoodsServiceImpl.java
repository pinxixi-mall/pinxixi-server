package com.pinxixi.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.controller.admin.param.GoodsQueryParam;
import com.pinxixi.dao.GoodsMapper;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.Goods;
import com.pinxixi.service.admin.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 商品分页列表
     * @param pageNum
     * @param pageSize
     * @param goodsQueryParam
     * @return
     */
    @Override
    public List<Goods> getGoodsPage(Integer pageNum, Integer pageSize, GoodsQueryParam goodsQueryParam) {
        PageHelper.startPage(pageNum, pageSize);
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
    public String updateGoods(Goods goods, AdminUser adminUser) {
        goods.setUpdateUser(adminUser.getUserId());
        goods.setUpdateTime(new Date());
        int rows = 0;
        if (goods.getGoodsId() != null) {
            //修改
            rows = goodsMapper.updateGoods(goods);
        } else {
            //新增
            goods.setCreateUser(adminUser.getUserId());
            goods.setCreateTime(new Date());
            rows = goodsMapper.insertGoods(goods);
        }
        if (rows > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        } else {
            return ServiceResultEnum.ERROR.getResult();
        }
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
