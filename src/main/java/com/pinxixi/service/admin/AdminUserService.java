package com.pinxixi.service.admin;

public interface AdminUserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    String register(String username, String password);

}
