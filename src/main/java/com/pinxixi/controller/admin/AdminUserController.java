package com.pinxixi.controller.admin;

import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.controller.admin.vo.AdminUserLoginParam;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.AdminUserToken;
import com.pinxixi.service.admin.AdminUserService;
import com.pinxixi.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 *管理后台-用户
 */
@Api(value = "v1.0.0", tags = "用户管理（管理端）")
@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 登录
     * @param adminUserLoginParam
     * @return
     */
    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public Result login(@RequestBody @Valid AdminUserLoginParam adminUserLoginParam, HttpServletRequest httpServletRequest) {
        AdminUserToken userToken = adminUserService.login(adminUserLoginParam.getUserName(), adminUserLoginParam.getPassword());

        HttpSession session = httpServletRequest.getSession();
        System.out.println(session.getId());

        if (userToken != null) {
            return Result.success(ServiceResultEnum.LOGIN_SUCCESS.getResult(), userToken);
        } else {
            return Result.fail(ServiceResultEnum.LOGIN_FAIL.getResult());
        }

    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        HttpSession session = httpServletRequest.getSession();
        System.out.println(session.getId());
        return null;
    }

    /**
     * 用户信息
     * @param userId
     * @return
     */
    @ApiOperation("管理员信息")
    @GetMapping("/users/{userId}")
    public Result getUserInfo(@PathVariable int userId) {
        AdminUser user = adminUserService.getUser(userId);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.fail(ServiceResultEnum.USER_NOT_FOUND.getResult());
        }
    }
}
