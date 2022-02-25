package com.pinxixi.dao;

import com.pinxixi.entity.AdminUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface AdminUserMapper {

    @Select("SELECT * FROM tb_admin_user WHERE user_name = #{username} AND password = #{password} AND locked = 0")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "nick_name", property = "nickName"),
    })
    AdminUser selectUser(String username, String password);
}
