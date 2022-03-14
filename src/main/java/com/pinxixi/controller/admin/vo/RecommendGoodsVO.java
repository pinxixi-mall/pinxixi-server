package com.pinxixi.controller.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RecommendGoodsVO {

    @ApiModelProperty("推荐ID")
    private Long RecommendId;

    @ApiModelProperty("推荐商品描述")
    private String recommendDesc;

    @ApiModelProperty("商品ID")
    private Long goodsId;

    @ApiModelProperty("商品图片")
    private String goodsImage;

    @ApiModelProperty("推荐商品名称")
    private String goodsName;

    @ApiModelProperty("商品价格")
    private Float goodsPrice;

    @ApiModelProperty("推荐商品排序")
    private int recommendSort;

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
