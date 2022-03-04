package com.pinxixi.service.admin;


import com.pinxixi.common.PageResult;
import com.pinxixi.controller.admin.vo.HomeCarouselVO;
import com.pinxixi.entity.HomeCarousel;

import java.util.List;

public interface HomeCarouselService {

    List<HomeCarousel> getCarousels();

    PageResult<HomeCarouselVO> getCarouselPage(Integer pageNum, Integer pageSize);

    String addCarousel(HomeCarousel homeCarousel);

}
