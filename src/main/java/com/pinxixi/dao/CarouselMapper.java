package com.pinxixi.dao;

import com.pinxixi.entity.Carousel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarouselMapper {

    /**
     * 所有轮播图列表
     * @return
     */
    List<Carousel> selectAll();


    List<Carousel> selectPage();

}
