package com.pinxixi.dao;

import com.pinxixi.entity.AdminUserToken;
import com.pinxixi.entity.TokenObj;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AdminUserTokenMapper {

    /**
     * 查询token
     * @param id
     * @return
     */
    AdminUserToken selectTokenById(int id);

    /**
     * 新建token
     * @param adminUserToken
     * @return
     */
    int insertToken(AdminUserToken adminUserToken);

    /**
     * 更新token
     * @param adminUserToken
     */
    int updateToken(AdminUserToken adminUserToken);
}
