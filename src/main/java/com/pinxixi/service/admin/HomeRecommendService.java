package com.pinxixi.service.admin;

import com.pinxixi.controller.admin.param.RecommendAddParam;
import com.pinxixi.controller.admin.param.RecommendQueryParam;
import com.pinxixi.controller.admin.param.RecommendUpdateParam;
import com.pinxixi.entity.RecommendGoods;

import java.util.List;

public interface HomeRecommendService {

    /**
     * 推荐列表（分页）
     * @param queryParam
     * @return
     */
    List<RecommendGoods> getRecommendPage(RecommendQueryParam queryParam);

    /**
     * 新增推荐
     * @param addParam
     * @return
     */
    String addRecommend(RecommendAddParam addParam);

    /**
     * 推荐修改
     * @param updateParam
     * @return
     */
    String updateRecommend(RecommendUpdateParam updateParam);
}
