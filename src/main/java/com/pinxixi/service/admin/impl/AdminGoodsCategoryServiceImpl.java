package com.pinxixi.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.pinxixi.controller.admin.param.GoodsCategoryAddParam;
import com.pinxixi.controller.admin.param.GoodsCategoryQueryParam;
import com.pinxixi.controller.admin.param.GoodsCategoryUpdateParam;
import com.pinxixi.controller.admin.vo.GoodsCategoryTreeVO;
import com.pinxixi.dao.GoodsCategoryMapper;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.GoodsCategory;
import com.pinxixi.service.admin.AdminGoodsCategoryService;
import com.pinxixi.utils.PinXiXiUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import reactor.util.annotation.Nullable;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminGoodsCategoryServiceImpl implements AdminGoodsCategoryService {

    @Resource
    private GoodsCategoryMapper categoryMapper;

    /**
     * 商品分类（分页）
     * @param queryParam
     * @return
     */
    @Override
    public List<GoodsCategoryTreeVO> selectCategoryPage(GoodsCategoryQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize());
        List<GoodsCategory> goodsCategories = categoryMapper.selectPage(queryParam);

        List<GoodsCategoryTreeVO> categoryTree = genCategoryTree(goodsCategories, queryParam.getStartLevel());

        return categoryTree;
    }

    /**
     * 商品分类（树形，不分页）
     * @param queryParam
     * @return
     */
    @Override
    public List<GoodsCategoryTreeVO> selectCategoryTree(GoodsCategoryQueryParam queryParam) {
        List<GoodsCategory> goodsCategories = categoryMapper.selectPage(queryParam);
        List<GoodsCategoryTreeVO> categoryTree = genCategoryTree(goodsCategories, queryParam.getStartLevel());
        return categoryTree;
    }

    /**
     * 根据类别查询商品分类
     * @param queryParam
     * @return
     */
    @Override
    public List<GoodsCategory> selectCategoryByLevel(GoodsCategoryQueryParam queryParam) {
        List<GoodsCategory> goodsCategoryList = categoryMapper.selectPage(queryParam);
        return goodsCategoryList;
    }

    /**
     * 根据categoryId查询
     * @param categoryId
     * @return
     */
    @Override
    public GoodsCategory getGoodsCategory(Long categoryId) {
        GoodsCategory goodsCategory = categoryMapper.selectCategory(categoryId);
        return goodsCategory;
    }

    /**
     * 新增商品分类
     * @param addParam
     * @return
     */
    @Override
    public String addCategory(GoodsCategoryAddParam addParam) {
        GoodsCategory goodsCategory = new GoodsCategory();
        BeanUtils.copyProperties(addParam, goodsCategory);
        int rows = categoryMapper.insertGoodsCategory(goodsCategory);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 修改商品分类
     * @param updateParam
     * @return
     */
    @Override
    public String updateCategory(GoodsCategoryUpdateParam updateParam, AdminUser adminUser) {
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setUpdateUser(adminUser.getUserId());
        BeanUtils.copyProperties(updateParam, goodsCategory);
        //TODO 如果有子类，删除所有子类
        int rows = categoryMapper.updateGoodsCategory(goodsCategory);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 生成树形分类
     * @param list
     * @return
     */
    public static List<GoodsCategoryTreeVO> genCategoryTree(List<GoodsCategory> list, @Nullable Long startLevel) {
        //一级
        List<GoodsCategory> level1List = null;
        //二级
        List<GoodsCategory> level2List;
        //三级
        List<GoodsCategory> level3List;

        if (startLevel == null || startLevel == 1) {
            level1List = list.stream().filter((GoodsCategory category) -> category.getCategoryLevel() == 1).sorted(Comparator.comparingInt(GoodsCategory::getCategorySort)).collect(Collectors.toList());
        }
        level2List = list.stream().filter((GoodsCategory category) -> category.getCategoryLevel() == 2).sorted(Comparator.comparingInt(GoodsCategory::getCategorySort)).collect(Collectors.toList());
        level3List = list.stream().filter((GoodsCategory category) -> category.getCategoryLevel() == 3).sorted(Comparator.comparingInt(GoodsCategory::getCategorySort)).collect(Collectors.toList());

        if ((level1List.size() > 0 && level2List.size() > 0) ||
            (level2List.size() > 0 && level3List.size() > 0)) {
            //有级别连续的列表才生成树状结构
            if (level1List.size() == 0) {
                //如果一级列表是0，则从二级开始处理
                return genTree(level2List, level3List);
            }
            return genTree(level1List, level2List, level3List);
        } else {
            //否则直接转换成VO返回
            List<GoodsCategoryTreeVO> collect = list.stream().map((GoodsCategory category) -> {
                GoodsCategoryTreeVO categoryTreeVO = new GoodsCategoryTreeVO();
                BeanUtils.copyProperties(category, categoryTreeVO);
                return categoryTreeVO;
            }).collect(Collectors.toList());
            return collect;
        }
    }

    /**
     * 树形分类处理
     * @param lists
     * @return
     */
    public static List<GoodsCategoryTreeVO> genTree(List<GoodsCategory>... lists) {
        int len = lists.length;
        if (len < 2) return null;

        List<GoodsCategoryTreeVO> treeList = new ArrayList();
        lists[0].stream().forEach((GoodsCategory level1Item) -> {
            //创建一级分类对象
            GoodsCategoryTreeVO level1TreeData = new GoodsCategoryTreeVO();
            BeanUtils.copyProperties(level1Item, level1TreeData);

            //二级->一级
            lists[1].stream().forEach((GoodsCategory level2Item) -> {
                //创建二级分类对象
                GoodsCategoryTreeVO level2TreeData = new GoodsCategoryTreeVO();
                BeanUtils.copyProperties(level2Item, level2TreeData);

                if (level2Item.getParentId() == level1Item.getCategoryId()) {
                    List<GoodsCategoryTreeVO> children = level1TreeData.getChildren();
                    if (children == null) {
                        children = new ArrayList<>();
                    }
                    GoodsCategoryTreeVO categoryTreeVO = new GoodsCategoryTreeVO();
                    BeanUtils.copyProperties(level2Item, categoryTreeVO);
                    children.add(categoryTreeVO);

                    if (len > 2) {
                        List<GoodsCategory> list = new ArrayList<>();
                        children.stream().forEach((GoodsCategoryTreeVO treeVO) -> {
                            GoodsCategory goodsCategory = new GoodsCategory();
                            BeanUtils.copyProperties(treeVO, goodsCategory);
                            list.add(goodsCategory);
                        });

                        //递归生成三级
                        children = genTree(list, lists[2]);
                    }

                    level1TreeData.setChildren(children);
                }
            });

            treeList.add(level1TreeData);
        });

        return treeList;
    }

}
