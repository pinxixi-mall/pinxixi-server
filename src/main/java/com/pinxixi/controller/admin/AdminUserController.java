package com.pinxixi.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "管理后台用户管理")
@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public String login() {
        return "success";
    }
}
