package com.pinxixi.dao;

import com.pinxixi.controller.admin.param.GoodsAddParam;
import com.pinxixi.entity.Goods;

import java.util.List;

public interface GoodsMapper {

    List<Goods> selectPage();

    int insertGoods(Goods goodsAddParam);

    int updateGoods(GoodsAddParam goodsAddParam);
}
