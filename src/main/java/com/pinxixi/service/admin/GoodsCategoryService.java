package com.pinxixi.service.admin;

import com.pinxixi.controller.admin.param.GoodsCategoryQueryParam;
import com.pinxixi.entity.GoodsCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类
 */
public interface GoodsCategoryService {

    List<GoodsCategory> selectCategoryPage(GoodsCategoryQueryParam queryParam);
}
