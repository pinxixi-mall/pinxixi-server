package com.pinxixi.controller.admin;

import com.pinxixi.common.PageResult;
import com.pinxixi.common.Result;
import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.controller.admin.param.HomeCarouselAddParam;
import com.pinxixi.controller.admin.param.HomeCarouselUpdateParam;
import com.pinxixi.controller.admin.vo.HomeCarouselVO;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.HomeCarousel;
import com.pinxixi.service.admin.AdminHomeCarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(value = "v1.0", tags = "首页配置")
@RequestMapping("/admin/home-manage")
public class AdminHomeCarouselController {

    @Autowired
    private AdminHomeCarouselService adminHomeCarouselService;

    /**
     * 轮播图列表
     * @return
     */
    @ApiOperation("首页轮播图")
    @GetMapping("/carousels")
    public Result<PageResult<HomeCarouselVO>> carousels(@RequestParam @ApiParam("页码") Integer pageNum,
                                                        @RequestParam @ApiParam("条数") Integer pageSize,
                                                        @AdminUserArgument AdminUser adminUser) {
        if (pageNum == null || pageSize == null || pageNum < 0 || pageSize < 0) {
            return Result.fail(ServiceResultEnum.PAGE_PARAM_ERROR.getResult());
        }

        //分页查询
        PageResult<HomeCarouselVO> carousels = adminHomeCarouselService.getCarouselPage(pageNum, pageSize);

        return Result.success(carousels);
    }

    /**
     * 轮播图新增
     * @param addParam
     * @return
     */
    @ApiOperation("轮播图新增")
    @PostMapping("/carousels")
    public Result addCarousels(@RequestBody @Valid HomeCarouselAddParam addParam, @AdminUserArgument AdminUser adminUser) {
        HomeCarousel homeCarousel = new HomeCarousel();
        homeCarousel.setCreateUser(adminUser.getUserId());
        homeCarousel.setUpdateUser(adminUser.getUserId());
        BeanUtils.copyProperties(addParam, homeCarousel);
        String result = adminHomeCarouselService.addCarousel(homeCarousel);
        return Result.common(result);
    }

    /**
     * 轮播图更新
     * @param updateParam
     * @param adminUser
     * @return
     */
    @ApiOperation("更新轮播图")
    @PutMapping("/carousels")
    public Result updateCarousels(@RequestBody @Valid HomeCarouselUpdateParam updateParam, @AdminUserArgument AdminUser adminUser) {
        HomeCarousel homeCarousel = new HomeCarousel();
        homeCarousel.setUpdateUser(adminUser.getUserId());
        BeanUtils.copyProperties(updateParam, homeCarousel);
        String result = adminHomeCarouselService.updateCarousel(homeCarousel);
        return Result.common(result);
    }
}
