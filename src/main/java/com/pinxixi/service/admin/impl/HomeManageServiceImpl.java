package com.pinxixi.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinxixi.common.PageResult;
import com.pinxixi.dao.CarouselMapper;
import com.pinxixi.entity.Carousel;
import com.pinxixi.service.admin.HomeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeManageServiceImpl implements HomeManageService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> carousels() {
        List<Carousel> carousels = carouselMapper.selectPage();
        return carousels;
    }

    @Override
    public PageInfo<Carousel> getCarousels(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Carousel> lists = carouselMapper.selectPage();
        //new PageResult<Carousel>(lists);
        PageInfo<Carousel> carousels = new PageInfo<Carousel>(lists);
        return carousels;
    }
}
