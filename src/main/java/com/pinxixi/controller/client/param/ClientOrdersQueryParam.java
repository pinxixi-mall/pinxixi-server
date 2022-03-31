package com.pinxixi.controller.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 订单列表接口参数
 */
@Data
public class ClientOrdersQueryParam {

    @ApiModelProperty("页码")
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码不能小于1")
    private Integer pageNum;

    @ApiModelProperty("每页条数")
    @NotNull(message = "每页条数不能为空")
    @Min(value = 1, message = "每页条数不能小于1")
    private Integer pageSize;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("订单状态")
    private Byte orderStatus;

}
