package com.pinxixi.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.pinxixi.controller.admin.param.RecommendAddParam;
import com.pinxixi.controller.admin.param.RecommendQueryParam;
import com.pinxixi.controller.admin.param.RecommendUpdateParam;
import com.pinxixi.dao.HomeRecommendMapper;
import com.pinxixi.entity.RecommendGoods;
import com.pinxixi.service.admin.HomeRecommendService;
import com.pinxixi.utils.PinXiXiUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeRecommendServiceImpl implements HomeRecommendService {

    @Resource
    private HomeRecommendMapper recommendMapper;

    /**
     * 推荐列表
     * @param queryParam
     * @return
     */
    @Override
    public List<RecommendGoods> getRecommendPage(RecommendQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
        List<RecommendGoods> goods = recommendMapper.selectPage(queryParam);
        return goods;
    }

    /**
     * 新增推荐
     * @param addParam
     * @return
     */
    @Override
    public String addRecommend(RecommendAddParam addParam) {
        RecommendGoods recommendGoods = new RecommendGoods();
        BeanUtils.copyProperties(addParam, recommendGoods);
        int rows = recommendMapper.insertRecommend(recommendGoods);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 推荐修改
     * @param updateParam
     * @return
     */
    @Override
    public String updateRecommend(RecommendUpdateParam updateParam) {
        RecommendGoods recommendGoods = new RecommendGoods();
        BeanUtils.copyProperties(updateParam, recommendGoods);
        int rows = recommendMapper.updateRecommend(recommendGoods);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }
}
