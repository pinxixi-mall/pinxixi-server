package com.pinxixi.service.admin;

import com.pinxixi.controller.admin.param.GoodsCategoryAddParam;
import com.pinxixi.controller.admin.param.GoodsCategoryQueryParam;
import com.pinxixi.controller.admin.param.GoodsCategoryUpdateParam;
import com.pinxixi.controller.admin.vo.GoodsCategoryTreeVO;
import com.pinxixi.controller.admin.vo.GoodsCategoryVO;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.GoodsCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类
 */
public interface GoodsCategoryService {

    List<GoodsCategoryTreeVO> selectCategoryPage(GoodsCategoryQueryParam queryParam);

    List<GoodsCategoryTreeVO> selectCategoryTree(GoodsCategoryQueryParam queryParam);

    List<GoodsCategory> selectCategoryByLevel(GoodsCategoryQueryParam queryParam);

    String addCategory(GoodsCategoryAddParam addParam);

    String updateCategory(GoodsCategoryUpdateParam updateParam, AdminUser adminUser);
}
