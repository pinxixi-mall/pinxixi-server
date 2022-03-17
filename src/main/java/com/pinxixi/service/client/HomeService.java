package com.pinxixi.service.client;

import com.pinxixi.controller.admin.vo.HomeCarouselVO;
import com.pinxixi.controller.admin.vo.RecommendGoodsVO;

import java.util.List;

public interface HomeService {

    List<HomeCarouselVO> carouselList();

    List<RecommendGoodsVO> recommendList(Integer pageNum, Integer pageSize);
}
