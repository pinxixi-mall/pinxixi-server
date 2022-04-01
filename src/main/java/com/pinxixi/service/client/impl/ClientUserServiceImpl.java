package com.pinxixi.service.client.impl;

import com.pinxixi.common.Constants;
import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.config.JWTConfig;
import com.pinxixi.config.PinXiXiException;
import com.pinxixi.controller.client.param.ClientUserRegisterParam;
import com.pinxixi.controller.client.param.ClientUserUpdateParam;
import com.pinxixi.dao.ClientUserMapper;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.entity.TokenObj;
import com.pinxixi.service.client.ClientUserService;
import com.pinxixi.utils.JWTUtils;
import com.pinxixi.utils.PinXiXiUtils;
import com.pinxixi.utils.RedisUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

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
    public Boolean logout(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(JWTConfig.tokenHeader);
        token = JWTUtils.splitTokenPrefix(token);
        //删除token缓存
        return redisUtils.del(Constants.ClIENT_TOKEN_CACHE_KEY + token);
    }

    /**
     * 用户信息
     * @param user
     * @return
     */
    @Override
    public ClientUser userInfo(ClientUser user) {
        return clientUserMapper.selectUserByUserId(user.getUserId());
    }

    /**
     * 注册
     * @param registerParam
     * @return
     */
    @Override
    public String register(ClientUserRegisterParam registerParam) {
        if (!registerParam.getPassword().equals(registerParam.getConfirmPassword())) {
            PinXiXiException.error(-1, ServiceResultEnum.PASSWORD_INCONSISTENT.getResult());
        }
        ClientUser exitsUser = clientUserMapper.selectUserByName(registerParam.getUserName());
        if (exitsUser != null) {
            PinXiXiException.error(-1, ServiceResultEnum.USER_EXITS.getResult());
        }
        ClientUser clientUser = new ClientUser();
        clientUser.setUserName(registerParam.getUserName());
        clientUser.setPassword(registerParam.getPassword());
        Integer rows = clientUserMapper.insertUser(clientUser);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 修改用户信息
     * @param updateParam
     * @return
     */
    @Override
    public Integer updateUserInfo(ClientUserUpdateParam updateParam, ClientUser user) {
        ClientUser clientUser = new ClientUser();
        BeanUtils.copyProperties(updateParam, clientUser);
        clientUser.setUserId(user.getUserId());
        Integer rows = clientUserMapper.updateUser(clientUser);
        return rows;
    }
}
