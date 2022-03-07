package com.pinxixi.controller.admin;

import com.pinxixi.common.GoodsTypeEnum;
import com.pinxixi.common.PageResult;
import com.pinxixi.common.Result;
import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.controller.admin.param.GoodsAddParam;
import com.pinxixi.controller.admin.param.GoodsQueryParam;
import com.pinxixi.controller.admin.param.GoodsUpdateParam;
import com.pinxixi.controller.admin.vo.GoodsVO;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.Goods;
import com.pinxixi.service.admin.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "商品管理")
@RequestMapping("/admin/goods-manage")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 商品列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("商品列表")
    @GetMapping("/goods/list")
    public Result<PageResult<GoodsVO>> goodsList(@RequestParam @ApiParam("页码") Integer pageNum,
                                                 @RequestParam @ApiParam("条数") Integer pageSize,
                                                 @RequestParam(required = false) @ApiParam("商品描述") String goodsDesc) {
        if (pageNum < 1 || pageSize < 0) {
            return Result.fail(ServiceResultEnum.PAGE_PARAM_ERROR.getResult());
        }
        GoodsQueryParam goodsQueryParam = new GoodsQueryParam();
        goodsQueryParam.setGoodsDesc(goodsDesc);
        List<Goods> goodsPage = goodsService.getGoodsPage(pageNum, pageSize, goodsQueryParam);
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
        String result = goodsService.addGoods(goods, adminUser);
        return Result.success(result);
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
        String result = goodsService.updateGoods(goods, adminUser);
        return Result.success(result);
    }


    @ApiOperation("商品上下架")
    @PutMapping("/goods/status")
    public Result goodsStatus() {
        return null;
    }

    /**
     * 商品详情
     * @param goodsId
     * @return
     */
    @GetMapping("/goods/{goodsId}")
    public Result<GoodsVO> goodsDetail(@PathVariable("goodsId") Integer goodsId) {
        Goods goods = goodsService.getGoodsDetail(goodsId);
        GoodsVO goodsVO = new GoodsVO();
        BeanUtils.copyProperties(goods, goodsVO);
        return Result.success(goodsVO);
    }

}
