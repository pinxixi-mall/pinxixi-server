package com.pinxixi.controller.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 商品查询接口参数
 */
@Data
public class GoodsQueryParam {

    @ApiModelProperty("页码")
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码不能小于1")
    private Integer pageNum;

    @ApiModelProperty("每页条数")
    @NotNull(message = "每页条数不能为空")
    private Integer pageSize;

    @ApiModelProperty("商品编号")
    private Long goodsId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品描述")
    private String goodsDesc;

    @ApiModelProperty("商品状态")
    private Byte goodsStatus;

}
