package com.pinxixi.dao;

import com.pinxixi.entity.AdminUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface AdminUserMapper {

    @Results(id = "adminUserMap", value = {
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "nick_name", property = "nickName"),
    })
    @Select("SELECT * FROM tb_admin_user WHERE user_name = #{username} AND password = #{password} AND locked = 0")
    AdminUser selectUser(String username, String password);

    @ResultMap(value = "adminUserMap")
    @Select("SELECT * FROM tb_admin_user WHERE user_id = #{id}")
    AdminUser selectUserById(int id);

    @ResultMap(value = "adminUserMap")
    @Select("SELECT * FROM tb_admin_user WHERE user_name = #{userName}")
    AdminUser selectUserByName(String userName);
}
