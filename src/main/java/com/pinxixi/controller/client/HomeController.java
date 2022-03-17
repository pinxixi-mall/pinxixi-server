package com.pinxixi.controller.client;

import com.pinxixi.common.PageResult;
import com.pinxixi.common.Result;
import com.pinxixi.controller.admin.vo.HomeCarouselVO;
import com.pinxixi.controller.admin.vo.RecommendGoodsVO;
import com.pinxixi.entity.HomeCarousel;
import com.pinxixi.service.client.HomeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @ApiOperation("首页轮播图")
    @GetMapping("/carousel")
    public Result<PageResult<HomeCarouselVO>> carousel() {
        List<HomeCarouselVO> homeCarousels = homeService.carouselList();
        PageResult<Object> pageResult = new PageResult<>(homeCarousels);
        return Result.success(pageResult);
    }

    @ApiOperation("首页推荐")
    @GetMapping("/recommend")
    public Result<PageResult<RecommendGoodsVO>> recommend(@RequestParam Integer pageNum, Integer pageSize) {
        List<RecommendGoodsVO> homeCarousels = homeService.recommendList(pageNum, pageSize);
        PageResult<Object> pageResult = new PageResult<>(homeCarousels);
        return Result.success(pageResult);
    }

}
