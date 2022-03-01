package com.pinxixi.service.admin.impl;

import com.pinxixi.common.Constants;
import com.pinxixi.config.JWTConfig;
import com.pinxixi.dao.AdminUserMapper;
import com.pinxixi.dao.AdminUserTokenMapper;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.AdminUserToken;
import com.pinxixi.entity.TokenObj;
import com.pinxixi.service.admin.AdminUserService;
import com.pinxixi.utils.RedisUtils;
import com.pinxixi.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private AdminUserTokenMapper adminUserTokenMapper;

    @Autowired
    private RedisUtils redisUtils;


    /**
     * 登录
     * token存redis
     * @param username
     * @param password
     * @return
     */
    @Override
    public AdminUserToken login(String username, String password) {
        AdminUser adminUser = adminUserMapper.selectUser(username, password);
        if (adminUser != null) {
            //新token对象
            TokenObj tokenObj = JWTUtils.generateToken(adminUser.getUserName(), adminUser.getPassword());

            AdminUserToken adminUserToken = new AdminUserToken();
            adminUserToken.setUserId(adminUser.getUserId());
            adminUserToken.setToken(tokenObj.getToken());
            adminUserToken.setUpdateTime(tokenObj.getUpdateTime());
            adminUserToken.setExpiredTime(tokenObj.getExpiredDate());

            redisUtils.set(Constants.ADMIN_TOKEN_CACHE_KEY + tokenObj.getToken(), adminUser, tokenObj.getExpiredDate().getTime());
            return adminUserToken;
        }

        //用户不存在
        return null;
    }

    /**
     * 登录
     * token存mysql
     * @param username
     * @param password
     * @return
     */
    @Override
    @Deprecated
    public AdminUserToken loginDeprecated(String username, String password) {
        AdminUser adminUser = adminUserMapper.selectUser(username, password);
        if (adminUser != null) {
            //用户存在，获取token
            AdminUserToken adminUserToken = adminUserTokenMapper.selectTokenById(adminUser.getUserId());
            //新token对象
            TokenObj tokenObj = JWTUtils.generateToken(adminUser.getUserName(), adminUser.getPassword());

            if (adminUserToken != null) {
                //有token，更新
                adminUserToken.setToken(tokenObj.getToken());
                adminUserToken.setUpdateTime(tokenObj.getUpdateTime());
                adminUserToken.setExpiredTime(tokenObj.getExpiredDate());
                if (adminUserTokenMapper.updateToken(adminUserToken) > 0) {
                    //缓存登录状态
                    redisUtils.set(Constants.ADMIN_TOKEN_CACHE_KEY + tokenObj.getToken(), adminUser, tokenObj.getExpiredDate().getTime());
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
                    //缓存登录状态
                    redisUtils.set(Constants.ADMIN_TOKEN_CACHE_KEY + tokenObj.getToken(), adminUser, tokenObj.getExpiredDate().getTime());
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

    /**
     * 退出登录
     * @param httpServletRequest
     * @return
     */
    @Override
    public Boolean logout(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(JWTConfig.tokenHeader);
        token = JWTUtils.splitTokenPrefix(token);
        //删除token缓存
        return redisUtils.del(Constants.ADMIN_TOKEN_CACHE_KEY + token);
    }

}
