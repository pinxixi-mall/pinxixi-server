package com.pinxixi.dao;

import com.pinxixi.controller.admin.param.GoodsQueryParam;
import com.pinxixi.entity.Goods;

import java.util.List;

public interface GoodsMapper {

    List<Goods> selectPage(GoodsQueryParam goodsQueryParam);

    int insertGoods(Goods goodsAddParam);

    int updateGoods(Goods goods);

    Goods selectGoods(Long goodsId);

    List<Goods> selectGoodsByIds(List<Long> goodsIds);
}
