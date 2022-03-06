package com.pinxixi.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.pinxixi.dao.GoodsMapper;
import com.pinxixi.entity.Goods;
import com.pinxixi.service.admin.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsPage(Integer pageNum, Integer pageSize, String type) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goods = goodsMapper.selectPage();
        return goods;
    }
}
