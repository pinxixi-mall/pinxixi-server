package com.pinxixi.service.client.impl;

import com.github.pagehelper.PageHelper;
import com.pinxixi.common.GoodsEnum;
import com.pinxixi.controller.admin.param.RecommendQueryParam;
import com.pinxixi.controller.admin.vo.HomeCarouselVO;
import com.pinxixi.dao.HomeCarouselMapper;
import com.pinxixi.dao.HomeRecommendMapper;
import com.pinxixi.entity.RecommendGoods;
import com.pinxixi.service.client.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeCarouselMapper carouselMapper;

    @Resource
    private HomeRecommendMapper recommendMapper;

    @Override
    public List<HomeCarouselVO> carouselList() {
        List<HomeCarouselVO> homeCarouselVOS = carouselMapper.selectPage((byte) GoodsEnum.CAROUSEL_ON_SHELF.getCode());
        return homeCarouselVOS;
    }

    @Override
    public List<RecommendGoods> recommendList(RecommendQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
        List<RecommendGoods> recommendGoods = recommendMapper.selectPage(queryParam);
        return recommendGoods;
    }
}
