package com.pinxixi.service.admin;

import com.pinxixi.entity.AdminUser;
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
     * 用户信息
     * @param userId
     * @return
     */
    AdminUser getUser(int userId);

}
