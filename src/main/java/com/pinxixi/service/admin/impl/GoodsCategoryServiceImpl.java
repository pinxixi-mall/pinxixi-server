package com.pinxixi.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.pinxixi.controller.admin.param.GoodsCategoryQueryParam;
import com.pinxixi.dao.GoodsCategoryMapper;
import com.pinxixi.entity.GoodsCategory;
import com.pinxixi.service.admin.GoodsCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Resource
    private GoodsCategoryMapper categoryMapper;

    @Override
    public List<GoodsCategory> selectCategoryPage(GoodsCategoryQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
        return categoryMapper.selectPage(queryParam);
    }

}
