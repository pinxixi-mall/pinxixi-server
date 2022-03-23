package com.pinxixi.controller.admin;

import com.pinxixi.common.PageResult;
import com.pinxixi.common.Result;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.controller.admin.param.GoodsAddParam;
import com.pinxixi.controller.admin.param.GoodsQueryParam;
import com.pinxixi.controller.admin.param.GoodsStatusUpdateParam;
import com.pinxixi.controller.admin.param.GoodsUpdateParam;
import com.pinxixi.controller.admin.vo.GoodsVO;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.Goods;
import com.pinxixi.service.admin.AdminGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "商品管理")
@RequestMapping("/admin/goods-manage")
public class AdminGoodsController {

    @Autowired
    private AdminGoodsService adminGoodsService;

    /**
     * 商品列表
     * @param goodsQueryParam
     * @return
     */
    @ApiOperation("商品列表")
    @GetMapping("/goods/list")
    public Result<PageResult<GoodsVO>> goodsList(@Valid GoodsQueryParam goodsQueryParam) {
        List<Goods> goodsPage = adminGoodsService.getGoodsPage(goodsQueryParam);
        PageResult<GoodsVO> result = new PageResult<>(goodsPage);
        return Result.success(result);
    }

    /**
     * 商品新增
     * @param goodsAddParam
     * @return
     */
    @ApiOperation("商品新增")
    @PostMapping("/goods")
    public Result addGoods(@RequestBody @Valid GoodsAddParam goodsAddParam, @AdminUserArgument AdminUser adminUser) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsAddParam, goods);
        String result = adminGoodsService.addGoods(goods, adminUser);
        return Result.common(result);
    }

    /**
     * 商品修改
     * @param goodsUpdateParam
     * @return
     */
    @ApiOperation("商品修改")
    @PutMapping ("/goods")
    public Result updateGoods(@RequestBody @Valid GoodsUpdateParam goodsUpdateParam, @AdminUserArgument AdminUser adminUser) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsUpdateParam, goods);
        String result = adminGoodsService.updateGoods(goods, adminUser);
        return Result.common(result);
    }

    /**
     * 商品上下架
     * @param updateParam
     * @return
     */
    @ApiOperation("商品上下架")
    @PutMapping("/goods/status")
    public Result goodsStatus(@RequestBody @Valid GoodsStatusUpdateParam updateParam, @AdminUserArgument AdminUser adminUser) {
        String result = adminGoodsService.updateStatus(updateParam, adminUser);
        return Result.common(result);
    }

    /**
     * 删除商品
     * @param goodsId
     * @param adminUser
     * @return
     */
    @ApiOperation("删除商品")
    @DeleteMapping("/goods/{goodsId}")
    public Result deleteGoods(@PathVariable Long goodsId, @AdminUserArgument AdminUser adminUser) {
        String result = adminGoodsService.deleteGoods(goodsId, adminUser);
        return Result.common(result);
    }

    /**
     * 商品详情
     * @param goodsId
     * @return
     */
    @GetMapping("/goods/{goodsId}")
    public Result<GoodsVO> goodsDetail(@PathVariable("goodsId") Integer goodsId) {
        Goods goods = adminGoodsService.getGoodsDetail(goodsId);
        GoodsVO goodsVO = new GoodsVO();
        BeanUtils.copyProperties(goods, goodsVO);
        return Result.success(goodsVO);
    }

}
