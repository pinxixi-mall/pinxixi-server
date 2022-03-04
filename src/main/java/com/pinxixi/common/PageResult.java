package com.pinxixi.common;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果
 * @param <T>
 */
@Data
public class PageResult <T> implements Serializable {

    @ApiModelProperty("页码")
    private int pageNum;

    @ApiModelProperty("条/页")
    private int pageSize;

    @ApiModelProperty("总数")
    private long total;

    @ApiModelProperty("列表")
    private List<T> list;

    public PageResult(List list) {
        PageInfo pageInfo = new PageInfo<>(list);
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
        this.list = pageInfo.getList();
    }

}
