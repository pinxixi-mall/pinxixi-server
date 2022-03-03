package com.pinxixi.controller.admin;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.pinxixi.common.Result;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.controller.admin.vo.CarouselVo;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.Carousel;
import com.pinxixi.service.admin.HomeManageService;
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
@Api(value = "v1.0", tags = "首页配置")
@RequestMapping("/admin/home-manage")
public class HomeManageController {

    @Autowired
    private HomeManageService homeManageService;

    /**
     * 首页轮播图
     * @return
     */
    @ApiOperation("首页轮播图")
    @GetMapping("/carousels")
    public Result<CarouselVo> carousels(@RequestParam @ApiParam("页码") Integer pageNum,
                                        @RequestParam @ApiParam("条数") Integer pageSize,
                                        @AdminUserArgument AdminUser adminUser) {
        if (pageNum == null || pageSize == null || pageNum < 0 || pageSize < 0) {
            return Result.fail("分页参数异常");
        }

        PageInfo<Carousel> carousels = homeManageService.getCarousels(pageNum, pageSize);

        return Result.success(carousels);
    }
}
