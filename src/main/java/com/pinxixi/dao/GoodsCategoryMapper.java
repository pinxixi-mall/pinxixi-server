package com.pinxixi.dao;

import com.pinxixi.controller.admin.param.GoodsCategoryQueryParam;
import com.pinxixi.controller.admin.vo.GoodsCategoryVO;
import com.pinxixi.entity.GoodsCategory;

import java.util.List;

public interface GoodsCategoryMapper {

    List<GoodsCategory> selectPage(GoodsCategoryQueryParam queryParam);

    List<GoodsCategory> selectAll();

    List<GoodsCategoryVO> selectByLevel(Byte level);

    int insertGoodsCategory(GoodsCategory goodsCategory);

    int updateGoodsCategory(GoodsCategory goodsCategory);
}
