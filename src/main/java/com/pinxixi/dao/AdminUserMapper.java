package com.pinxixi.dao;

import com.pinxixi.entity.AdminUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface AdminUserMapper {

    /**
     * 根据用户名+用户密码查询
     * @param username
     * @param password
     * @return
     */
    @Results(id = "adminUserMap", value = {
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "nick_name", property = "nickName"),
    })
    @Select("SELECT * FROM tb_admin_user WHERE user_name = #{username} AND password = #{password} AND locked = 0")
    AdminUser selectUser(String username, String password);

    /**
     * 根据用户id查询
     * @param id
     * @return
     */
    @ResultMap(value = "adminUserMap")
    @Select("SELECT * FROM tb_admin_user WHERE user_id = #{id}")
    AdminUser selectUserById(int id);

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    @ResultMap(value = "adminUserMap")
    @Select("SELECT * FROM tb_admin_user WHERE user_name = #{userName}")
    AdminUser selectUserByName(String userName);
}
