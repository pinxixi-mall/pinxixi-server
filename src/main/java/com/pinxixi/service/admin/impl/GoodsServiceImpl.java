package com.pinxixi.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.controller.admin.param.GoodsAddParam;
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
     * @return
     */
    @Override
    public List<Goods> getGoodsPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goods = goodsMapper.selectPage();
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
        goods.setCreateUser(adminUser.getUserId());
        goods.setCreateTime(new Date());
        goodsMapper.insertGoods(goods);
        return null;
    }


}
