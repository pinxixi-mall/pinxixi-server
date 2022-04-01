package com.pinxixi.dao;

import com.pinxixi.entity.ClientUser;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientUserMapper {

    ClientUser selectUser(String userName, String password);

    ClientUser selectUserByName(String userName);

    ClientUser selectUserByUserId(Integer userId);

    Integer insertUser(ClientUser clientUser);
}
