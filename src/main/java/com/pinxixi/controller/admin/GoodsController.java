package com.pinxixi.controller.admin;

import com.pinxixi.common.GoodsTypeEnum;
import com.pinxixi.common.PageResult;
import com.pinxixi.common.Result;
import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.controller.admin.param.GoodsAddParam;
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
    @GetMapping("/goods-list")
    public Result<PageResult<GoodsVO>> goodsList(@RequestParam @ApiParam("页码") Integer pageNum,
                                                  @RequestParam @ApiParam("条数") Integer pageSize) {
        if (pageNum < 1 || pageSize < 0) {
            return Result.fail(ServiceResultEnum.PAGE_PARAM_ERROR.getResult());
        }
        List<Goods> goodsPage = goodsService.getGoodsPage(pageNum, pageSize);
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
    public Result goods(@RequestBody @Valid GoodsAddParam goodsAddParam, @AdminUserArgument AdminUser adminUser) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsAddParam, goods);
        String result = goodsService.updateGoods(goods, adminUser);
        return Result.success(result);
    }

}