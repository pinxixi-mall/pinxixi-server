package com.pinxixi.service.client;

import com.pinxixi.controller.admin.param.RecommendQueryParam;
import com.pinxixi.controller.admin.vo.HomeCarouselVO;
import com.pinxixi.entity.RecommendGoods;

import java.util.List;

public interface ClientHomeService {

    List<HomeCarouselVO> carouselList();

    List<RecommendGoods> recommendList(RecommendQueryParam queryParam);
}
