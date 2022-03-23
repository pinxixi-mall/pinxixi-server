package com.pinxixi.controller.client;

import com.pinxixi.common.Result;
import com.pinxixi.controller.admin.param.GoodsCategoryQueryParam;
import com.pinxixi.controller.admin.vo.GoodsCategoryTreeVO;
import com.pinxixi.entity.GoodsCategory;
import com.pinxixi.service.admin.AdminGoodsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "商品-客户端")
@RestController
@RequestMapping("/client/goods")
public class ClientGoodsCategoryController {

    @Autowired
    private AdminGoodsCategoryService categoryService;

    /**
     * 商品分类
     * @param queryParam
     * @return
     */
    @ApiOperation("商品分类")
    @GetMapping("/category")
    Result<GoodsCategory> category(GoodsCategoryQueryParam queryParam) {
        List<GoodsCategory> goodsCategoryList = categoryService.selectCategoryByLevel(queryParam);
        return Result.success(goodsCategoryList);
    }

    /**
     * 商品分类（树形）
     * @param queryParam
     * @return
     */
    @ApiOperation("商品分类")
    @GetMapping("/category/tree")
    Result<GoodsCategoryTreeVO> categoryTree(GoodsCategoryQueryParam queryParam) {
        List<GoodsCategoryTreeVO> goodsCategoryTreeVOS = categoryService.selectCategoryTree(queryParam);
        return Result.success(goodsCategoryTreeVOS);
    }

}
