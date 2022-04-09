package com.pinxixi.controller.client;

import com.pinxixi.common.PageResult;
import com.pinxixi.common.Result;
import com.pinxixi.controller.admin.param.RecommendQueryParam;
import com.pinxixi.controller.admin.vo.HomeCarouselVO;
import com.pinxixi.controller.admin.vo.RecommendGoodsVO;
import com.pinxixi.entity.RecommendGoods;
import com.pinxixi.service.client.ClientHomeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 客户端-首页
 */
@RestController
@RequestMapping("/client/home")
public class ClientHomeController {

    @Autowired
    private ClientHomeService clientHomeService;

    @ApiOperation("首页轮播图")
    @GetMapping("/carousel")
    public Result<PageResult<HomeCarouselVO>> carousel() {
        List<HomeCarouselVO> homeCarousels = clientHomeService.carouselList();
        PageResult<Object> pageResult = new PageResult<>(homeCarousels);
        return Result.success(pageResult);
    }

    @ApiOperation("首页推荐")
    @GetMapping("/recommend")
    public Result<PageResult<RecommendGoodsVO>> recommend(@Valid RecommendQueryParam queryParam) {
        List<RecommendGoods> recommendGoods = clientHomeService.recommendList(queryParam);
        PageResult<Object> pageResult = new PageResult<>(recommendGoods);
        return Result.success(pageResult);
    }

}
