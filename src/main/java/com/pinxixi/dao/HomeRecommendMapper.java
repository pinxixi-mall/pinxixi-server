package com.pinxixi.dao;

import com.pinxixi.controller.admin.param.RecommendQueryParam;
import com.pinxixi.entity.RecommendGoods;

import java.util.List;

public interface HomeRecommendMapper {

    List<RecommendGoods> selectPage(RecommendQueryParam queryParam);

    int insertRecommend(RecommendGoods goods);

    int updateRecommend(RecommendGoods goods);

    RecommendGoods selectByRecommend(Long recommendId);

    RecommendGoods selectByGoodsId(Long goodsId);

}
