package com.pinxixi.dao;

import com.pinxixi.entity.AdminUser;
import org.apache.ibatis.annotations.Select;

public interface AdminUserMapper {

    @Select("SELECT * FROM tb_admin_user WHERE username = #{username}} AND passwprd = #{password}} AND locked = 0")
    AdminUser selectUser(String username, String password);
}
