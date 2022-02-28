package com.pinxixi.service.admin;

import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.AdminUserToken;

import javax.servlet.http.HttpServletRequest;

public interface AdminUserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    AdminUserToken login(String username, String password);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Deprecated
    AdminUserToken loginDeprecated(String username, String password);

    /**
     * 用户信息
     * @param userId
     * @return
     */
    AdminUser getUser(int userId);

    /**
     * 退出登录
     * @param httpServletRequest
     */
    Boolean logout(HttpServletRequest httpServletRequest);
}
