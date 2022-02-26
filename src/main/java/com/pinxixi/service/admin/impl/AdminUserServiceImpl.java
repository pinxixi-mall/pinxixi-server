package com.pinxixi.service.admin.impl;

import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.dao.AdminUserMapper;
import com.pinxixi.dao.AdminUserTokenMapper;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.AdminUserToken;
import com.pinxixi.entity.TokenObj;
import com.pinxixi.service.admin.AdminUserService;
import com.pinxixi.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private AdminUserTokenMapper adminUserTokenMapper;


    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public AdminUserToken login(String username, String password) {
        AdminUser adminUser = adminUserMapper.selectUser(username, password);
        if (adminUser != null) {
            //用户存在，获取token
            AdminUserToken adminUserToken = adminUserTokenMapper.selectTokenById(adminUser.getUserId());
            //新token对象
            TokenObj tokenObj = TokenUtils.generateToken(adminUser.getUserName(), adminUser.getPassword());

            if (adminUserToken != null) {
                //有token，更新
                adminUserToken.setToken(tokenObj.getToken());
                adminUserToken.setUpdateTime(tokenObj.getUpdateTime());
                adminUserToken.setExpiredTime(tokenObj.getExpiredDate());
                if (adminUserTokenMapper.updateToken(adminUserToken) > 0) {
                    return adminUserToken;
                };
            } else {
                //没token，新建
                adminUserToken = new AdminUserToken();
                adminUserToken.setUserId(adminUser.getUserId());
                adminUserToken.setToken(tokenObj.getToken());
                adminUserToken.setUpdateTime(tokenObj.getUpdateTime());
                adminUserToken.setExpiredTime(tokenObj.getExpiredDate());
                if (adminUserTokenMapper.insertToken(adminUserToken) > 0) {
                    return adminUserToken;
                }
            }
        }

        //用户不存在
        return null;
    }

    /**
     * 根据ID获取用户信息
     * @param userId
     * @return
     */
    @Override
    public AdminUser getUser(int userId) {
        return adminUserMapper.selectUserById(userId);
    }

}
