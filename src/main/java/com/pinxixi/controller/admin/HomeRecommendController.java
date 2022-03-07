package com.pinxixi.controller.admin;

import com.pinxixi.common.PageResult;
import com.pinxixi.common.Result;
import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.controller.admin.param.GoodsQueryParam;
import com.pinxixi.controller.admin.vo.GoodsVO;
import com.pinxixi.entity.Goods;
import com.pinxixi.service.admin.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "首页推荐管理")
@RequestMapping("/admin/home-manage")
public class HomeRecommendController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 首页推荐列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("首页推荐列表")
    @GetMapping("/recommends")
    public Result<PageResult<GoodsVO>> recommends(@RequestParam @ApiParam("页码") Integer pageNum,
                                                  @RequestParam @ApiParam("条数") Integer pageSize) {
        if (pageNum == null || pageSize == null || pageNum < 1 || pageSize < 0) {
            return Result.fail(ServiceResultEnum.PAGE_PARAM_ERROR.getResult());
        }
        GoodsQueryParam goodsQueryParam = new GoodsQueryParam();
        List<Goods> goodsPage = goodsService.getGoodsPage(pageNum, pageSize, goodsQueryParam);
        PageResult<GoodsVO> result = new PageResult<>(goodsPage);
        return Result.success(result);
    }

}
