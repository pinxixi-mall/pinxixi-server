package com.pinxixi.controller.admin;

import com.pinxixi.common.PageResult;
import com.pinxixi.common.Result;
import com.pinxixi.controller.admin.param.GoodsCategoryQueryParam;
import com.pinxixi.controller.admin.vo.GoodsCategoryVO;
import com.pinxixi.entity.GoodsCategory;
import com.pinxixi.service.admin.GoodsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "商品分类")
@RequestMapping("/admin/goods-manage")
public class GoodsCategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     * 商品分类列表（分页）
     * @param queryParam
     * @return
     */
    @ApiOperation("商品分类列表")
    @GetMapping("/category/list")
    public Result<PageResult<GoodsCategoryVO>> categoryList(@Valid GoodsCategoryQueryParam queryParam) {
        List<GoodsCategory> goodsCategories = goodsCategoryService.selectCategoryPage(queryParam);
        PageResult<GoodsCategoryVO> pageResult = new PageResult<>(goodsCategories);
        return Result.success(pageResult);
    }

}
