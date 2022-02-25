package com.pinxixi.service.admin;

import com.pinxixi.entity.AdminUserToken;

public interface AdminUserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    AdminUserToken login(String username, String password);

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    String register(String username, String password);

}
