package com.pinxixi.common;

public class Constants {

    //管理后台
    public static final String PINXINXI_ADMIN = "admin";

    //客户端
    public static final String PINXINXI_CLIENT = "client";

    //管理后台token在redis中的key前缀
    public static final String ADMIN_TOKEN_CACHE_KEY = "admin:token:";

    //客户端token在redis中的key前缀
    public static final String ClIENT_TOKEN_CACHE_KEY = "client:token:";

    //文件上传保存路径文件夹
    public static final String UPLOAD_DIR = "upload";

    public static final Integer PAGE_NUM = 1;

    public static final Integer PAGE_SIZE = 5;
}
