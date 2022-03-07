package com.pinxixi.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.pinxixi.controller.admin.param.GoodsAddParam;
import com.pinxixi.controller.admin.param.GoodsQueryParam;
import com.pinxixi.dao.GoodsMapper;
import com.pinxixi.entity.Goods;
import com.pinxixi.service.admin.GoodsService;
import com.pinxixi.service.admin.HomeRecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeRecommendServiceImpl implements HomeRecommendService {

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
        GoodsQueryParam goodsQueryParam = new GoodsQueryParam();
        List<Goods> goods = goodsMapper.selectPage(goodsQueryParam);
        return goods;
    }

    /**
     * 商品新增
     * @param goods
     * @return
     */
    @Override
    public String updateGoods(Goods goods) {
        goodsMapper.insertGoods(goods);
        return null;
    }
}
