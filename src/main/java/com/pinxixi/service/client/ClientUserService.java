package com.pinxixi.service.client;

import com.pinxixi.controller.client.param.ClientUserRegisterParam;
import com.pinxixi.controller.client.param.ClientUserUpdateParam;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.entity.TokenObj;

import javax.servlet.http.HttpServletRequest;

public interface ClientUserService {

    TokenObj login(String userName, String password);

    Boolean logout(HttpServletRequest httpServletRequest);

    ClientUser userInfo(ClientUser user);

    String register(ClientUserRegisterParam registerParam);

    Integer updateUserInfo(ClientUserUpdateParam updateParam, ClientUser user);
}
