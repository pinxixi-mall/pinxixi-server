package com.pinxixi.service.client;

import com.pinxixi.entity.ClientUser;
import com.pinxixi.entity.TokenObj;

public interface ClientUserService {

    TokenObj login(String userName, String password);

    Boolean logout(ClientUser clientUser);

}
