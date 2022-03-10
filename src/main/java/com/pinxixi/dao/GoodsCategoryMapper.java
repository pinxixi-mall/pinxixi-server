package com.pinxixi.dao;

import com.pinxixi.controller.admin.param.GoodsCategoryQueryParam;
import com.pinxixi.entity.GoodsCategory;

import java.util.List;

public interface GoodsCategoryMapper {

    List<GoodsCategory> selectPage(GoodsCategoryQueryParam queryParam);

}
