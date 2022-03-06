package com.pinxixi.service.admin;


import com.pinxixi.common.PageResult;
import com.pinxixi.controller.admin.vo.HomeCarouselVO;
import com.pinxixi.entity.HomeCarousel;

import java.util.List;

public interface HomeCarouselService {

    /**
     * 所有轮播图
     * @return
     */
    List<HomeCarousel> getCarousels();

    /**
     * 轮播图分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult<HomeCarouselVO> getCarouselPage(Integer pageNum, Integer pageSize);

    /**
     * 添加轮播图
     * @param homeCarousel
     * @return
     */
    String addCarousel(HomeCarousel homeCarousel);

    /**
     * 更新轮播图
     * @param homeCarousel
     * @return
     */
    String updateCarousel(HomeCarousel homeCarousel);
}
