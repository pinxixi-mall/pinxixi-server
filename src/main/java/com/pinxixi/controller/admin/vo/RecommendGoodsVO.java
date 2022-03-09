package com.pinxixi.controller.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RecommendGoodsVO {

    @ApiModelProperty("推荐ID")
    private Long RecommendId;

    @ApiModelProperty("商品ID")
    private Long goodsId;

    @ApiModelProperty("推荐商品名称")
    private String goodsName;

    @ApiModelProperty("推荐商品排序")
    private int recommendSort;

    @ApiModelProperty("商品图片")
    private String goodsImage;

    //@ApiModelProperty("创建人ID")
    //private Integer createUser;
    //
    //@ApiModelProperty("创建时间")
    //private Date createTime;
    //
    //@ApiModelProperty("更新人ID")
    //private Integer updateUser;
    //
    //@ApiModelProperty("更新人时间")
    //private Date updateTime;

}
