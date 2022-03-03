package com.pinxixi.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResult <T> implements Serializable {

    private int pageNum;

    private int pageSize;

    private int total;

    private List<T> list;
}
