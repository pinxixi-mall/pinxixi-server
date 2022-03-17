package com.pinxixi.service.client.impl;

import com.pinxixi.common.Constants;
import com.pinxixi.dao.ClientUserMapper;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.entity.TokenObj;
import com.pinxixi.service.client.ClientUserService;
import com.pinxixi.utils.JWTUtils;
import com.pinxixi.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientUserServiceImpl implements ClientUserService {

    @Autowired
    private ClientUserMapper clientUserMapper;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @Override
    public TokenObj login(String userName, String password) {
        ClientUser clientUser = clientUserMapper.selectUser(userName, password);
        if (clientUser != null) {
            TokenObj tokenObj = JWTUtils.generateToken(userName, password);
            redisUtils.set(Constants.ClIENT_TOKEN_CACHE_KEY + tokenObj.getToken(), clientUser, tokenObj.getExpiredDate().getTime());
            return tokenObj;
        }
        return null;
    }

    @Override
    public Boolean logout(ClientUser clientUser) {
        return null;
    }
}
