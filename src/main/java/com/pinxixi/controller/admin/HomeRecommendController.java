package com.pinxixi.controller.admin;

import com.pinxixi.common.PageResult;
import com.pinxixi.common.Result;
import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.controller.admin.param.RecommendAddParam;
import com.pinxixi.controller.admin.param.RecommendQueryParam;
import com.pinxixi.controller.admin.param.RecommendUpdateParam;
import com.pinxixi.controller.admin.vo.RecommendGoodsVO;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.RecommendGoods;
import com.pinxixi.service.admin.HomeRecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "首页推荐管理")
@RequestMapping("/admin/home-manage")
public class HomeRecommendController {

    @Autowired
    private HomeRecommendService homeRecommendService;

    /**
     * 首页推荐列表
     * @param queryParam
     * @return
     */
    @ApiOperation("首页推荐列表")
    @GetMapping("/recommend")
    public Result<PageResult<RecommendGoodsVO>> recommends(@Valid RecommendQueryParam queryParam) {
        List<RecommendGoods> goodsPage = homeRecommendService.getRecommendPage(queryParam);
        PageResult<RecommendGoodsVO> result = new PageResult<>(goodsPage);
        return Result.success(result);
    }

    /**
     * 新增推荐商品
     * @param addParam
     * @return
     */
    @ApiOperation("新增推荐商品")
    @PostMapping("/recommend")
    public Result addRecommend(@RequestBody @Valid RecommendAddParam addParam) {
        String result = homeRecommendService.addRecommend(addParam);
        if (result == ServiceResultEnum.GOODS_EXISTS.getResult()) {
            return Result.fail(result);
        }
        return Result.common(result);
    }

    /**
     * 推荐商品修改
     * @param updateParam
     * @return
     */
    @ApiOperation("修改推荐商品")
    @PutMapping("/recommend")
    public Result updateRecommend(@RequestBody @Valid RecommendUpdateParam updateParam) {
        String result = homeRecommendService.updateRecommend(updateParam);
        return Result.common(result);
    }

    /**
     * 推荐商品删除
     * @param recommendId
     * @return
     */
    @ApiOperation("删除推荐商品")
    @DeleteMapping("/recommend/{recommendId}")
    public Result updateRecommend(@PathVariable Long recommendId, @AdminUserArgument AdminUser adminUser) {
        String result = homeRecommendService.deleteRecommend(recommendId, adminUser);
        return Result.common(result);
    }

}
