package com.pinxixi.service.admin;

import com.pinxixi.controller.admin.param.GoodsCategoryQueryParam;
import com.pinxixi.controller.admin.vo.GoodsCategoryTreeVO;
import com.pinxixi.entity.GoodsCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类
 */
public interface GoodsCategoryService {

    List<GoodsCategoryTreeVO> selectCategoryPage(GoodsCategoryQueryParam queryParam);

    List<GoodsCategoryTreeVO> selectCategoryAll(GoodsCategoryQueryParam queryParam);
}
