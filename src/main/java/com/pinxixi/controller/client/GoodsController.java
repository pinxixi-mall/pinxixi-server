package com.pinxixi.controller.client;

import com.pinxixi.common.Result;
import com.pinxixi.controller.admin.vo.GoodsVO;
import com.pinxixi.entity.Goods;
import com.pinxixi.service.admin.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation("商品详情")
    @GetMapping("/detail/{goodsId}")
    Result<GoodsVO> goodsDetail(@PathVariable Integer goodsId) {
        Goods goods = goodsService.getGoodsDetail(goodsId);
        if (goods == null) {

        }
        return Result.success(goods);
    }

}
