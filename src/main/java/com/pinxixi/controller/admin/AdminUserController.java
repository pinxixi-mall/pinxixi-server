package com.pinxixi.controller.admin;

import com.pinxixi.controller.admin.vo.AdminUserLoginParam;
import com.pinxixi.service.admin.AdminUserService;
import com.pinxixi.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "用户管理（管理端）")
@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public Result login(@RequestBody @Valid AdminUserLoginParam adminUserLoginParam) {
        adminUserService.login(adminUserLoginParam.getUserName(), adminUserLoginParam.getPassword());
        return Result.success();
    }
}
