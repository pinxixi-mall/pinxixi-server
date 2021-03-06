package com.pinxixi.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.pinxixi.common.PageResult;
import com.pinxixi.controller.admin.vo.HomeCarouselVO;
import com.pinxixi.dao.HomeCarouselMapper;
import com.pinxixi.entity.HomeCarousel;
import com.pinxixi.service.admin.AdminHomeCarouselService;
import com.pinxixi.utils.PinXiXiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminHomeCarouselServiceImpl implements AdminHomeCarouselService {

    @Autowired
    private HomeCarouselMapper homeCarouselMapper;

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<HomeCarousel> getCarousels() {
        return homeCarouselMapper.selectAll();
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult<HomeCarouselVO> getCarouselPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HomeCarouselVO> list = homeCarouselMapper.selectPage(null);
        PageResult<HomeCarouselVO> pageResult = new PageResult<>(list);
        return pageResult;
    }

    /**
     * 轮播图新增
     * @param homeCarousel
     * @return
     */
    @Override
    public String addCarousel(HomeCarousel homeCarousel) {
        int rows = homeCarouselMapper.insertHomeCarousel(homeCarousel);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 轮播图更新
     * @param homeCarousel
     * @return
     */
    @Override
    public String updateCarousel(HomeCarousel homeCarousel) {
        homeCarousel.setUpdateTime(new Date());
        int rows = homeCarouselMapper.updateCarousel(homeCarousel);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

}
