package com.pinxixi.dao;

import com.pinxixi.entity.Goods;

import java.util.List;

public interface GoodsMapper {

    List<Goods> selectPage();

}
