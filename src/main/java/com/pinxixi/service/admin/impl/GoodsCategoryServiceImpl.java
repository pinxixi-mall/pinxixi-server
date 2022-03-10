package com.pinxixi.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.pinxixi.controller.admin.param.GoodsCategoryQueryParam;
import com.pinxixi.dao.GoodsCategoryMapper;
import com.pinxixi.entity.GoodsCategory;
import com.pinxixi.service.admin.GoodsCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Resource
    private GoodsCategoryMapper categoryMapper;

    @Override
    public List<GoodsCategory> selectCategoryPage(GoodsCategoryQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
        List<GoodsCategory> goodsCategories = categoryMapper.selectPage(queryParam);
        genTreeData(goodsCategories);
        return goodsCategories;
    }

    /**
     * 生成树形分类
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List genTreeData(List<T> list) {
        ArrayList<Object> newList = new ArrayList<>();
        //list.stream().filter((GoodsCategory category) -> newList.contains(category.getCategoryLevel()));
        for (T t : list) {
            System.out.println(t);

        }

        return list;
    }

}
