package com.pinxixi.controller.admin;

import com.pinxixi.common.PageResult;
import com.pinxixi.common.Result;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.controller.admin.param.GoodsCategoryAddParam;
import com.pinxixi.controller.admin.param.GoodsCategoryQueryParam;
import com.pinxixi.controller.admin.param.GoodsCategoryUpdateParam;
import com.pinxixi.controller.admin.vo.GoodsCategoryTreeVO;
import com.pinxixi.controller.admin.vo.GoodsCategoryVO;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.GoodsCategory;
import com.pinxixi.service.admin.AdminGoodsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "商品分类")
@RequestMapping("/admin/goods-manage")
public class AdminGoodsCategoryController {

    @Autowired
    private AdminGoodsCategoryService adminGoodsCategoryService;

    /**
     * 商品分类列表（分页）
     * @param queryParam
     * @return
     */
    @ApiOperation("商品分类列表")
    @GetMapping("/category/page")
    public Result<PageResult<GoodsCategoryTreeVO>> categoryPage(@Valid GoodsCategoryQueryParam queryParam) {
        List<GoodsCategoryTreeVO> goodsCategories = adminGoodsCategoryService.selectCategoryPage(queryParam);
        PageResult<GoodsCategoryVO> pageResult = new PageResult<>(goodsCategories);
        return Result.success(pageResult);
    }

    /**
     * 树形商品分类列表（不分页）
     * @return
     */
    @ApiOperation("商品分类列表")
    @GetMapping("/category/list")
    public Result<GoodsCategoryTreeVO> categoryList(GoodsCategoryQueryParam queryParam) {
        List<GoodsCategoryTreeVO> goodsCategories = adminGoodsCategoryService.selectCategoryTree(queryParam);
        return Result.success(goodsCategories);
    }

    /**
     * 新增商品分类
     * @param addParam
     * @return
     */
    @ApiOperation("新增商品分类")
    @PostMapping("/category")
    public Result addCategory(@RequestBody @Valid GoodsCategoryAddParam addParam) {
        String result = adminGoodsCategoryService.addCategory(addParam);
        return Result.common(result);
    }

    /**
     * 修改商品分类
     * @param updateParam
     * @param adminUser
     * @return
     */
    @ApiOperation("修改商品分类")
    @PutMapping("/category")
    public Result updateCategory(@RequestBody @Valid GoodsCategoryUpdateParam updateParam, @AdminUserArgument AdminUser adminUser) {
        String result = adminGoodsCategoryService.updateCategory(updateParam, adminUser);
        return Result.common(result);
    }

    /**
     * 删除商品分类
     * @param categoryId
     * @return
     */
    @ApiOperation("删除商品分类")
    @DeleteMapping("/category/{categoryId}")
    public Result deleteCategory(@PathVariable Long categoryId, @AdminUserArgument AdminUser adminUser) {
        GoodsCategoryUpdateParam updateParam = new GoodsCategoryUpdateParam();
        updateParam.setCategoryId(categoryId);
        updateParam.setIsDeleted((byte)1);
        String result = adminGoodsCategoryService.updateCategory(updateParam, adminUser);
        return Result.common(result);
    }

    /**
     * 商品分类by级别
     * @return
     */
    @ApiOperation("商品分类级别")
    @GetMapping("/category/level")
    public Result<GoodsCategory> categoryLevel(GoodsCategoryQueryParam queryParam) {
        List<GoodsCategory> goodsCategories = adminGoodsCategoryService.selectCategoryByLevel(queryParam);
        return Result.success(goodsCategories);
    }

}
