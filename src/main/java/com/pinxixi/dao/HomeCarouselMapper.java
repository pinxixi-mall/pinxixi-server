package com.pinxixi.dao;

import com.pinxixi.controller.admin.vo.HomeCarouselVO;
import com.pinxixi.entity.HomeCarousel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeCarouselMapper {

    /**
     * 所有轮播图列表
     * @return
     */
    List<HomeCarousel> selectAll();


    /**
     * 分页查询
     * @return
     */
    List<HomeCarouselVO> selectPage();

    /**
     * 轮播图新增
     * @param homeCarousel
     * @return
     */
    int insertHomeCarousel(HomeCarousel homeCarousel);

}
