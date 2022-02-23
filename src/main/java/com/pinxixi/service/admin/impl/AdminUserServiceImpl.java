package com.pinxixi.service.admin.impl;

import com.pinxixi.dao.AdminUserMapper;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public String login(String username, String password) {
        AdminUser adminUser = adminUserMapper.selectUser(username, password);
        return null;
    }

    @Override
    public String register(String username, String password) {
        return null;
    }
}
