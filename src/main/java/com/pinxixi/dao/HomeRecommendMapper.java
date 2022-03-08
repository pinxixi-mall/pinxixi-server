package com.pinxixi.dao;

import com.pinxixi.controller.admin.param.GoodsQueryParam;
import com.pinxixi.entity.Goods;

import java.util.List;

public interface HomeRecommendMapper {


    List<Goods> selectPage(GoodsQueryParam goodsQueryParam);

    int insertGoods(Goods goodsAddParam);

    int updateGoods(Goods goods);

    Goods selectGoods(Integer goodsId);

}
