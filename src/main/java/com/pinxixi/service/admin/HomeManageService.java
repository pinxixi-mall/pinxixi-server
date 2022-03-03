package com.pinxixi.service.admin;


import com.github.pagehelper.PageInfo;
import com.pinxixi.entity.Carousel;

import java.util.List;

public interface HomeManageService {

    List<Carousel> carousels();

    PageInfo<Carousel> getCarousels(Integer pageNum, Integer pageSize);
}
