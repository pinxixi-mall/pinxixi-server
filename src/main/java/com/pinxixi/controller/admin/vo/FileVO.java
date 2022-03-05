package com.pinxixi.controller.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FileVO {

    @ApiModelProperty("文件名")
    private String name;

    @ApiModelProperty("文件地址")
    private String url;

}
