package com.pinxixi.controller.admin;

import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.controller.admin.param.AdminUserLoginParam;
import com.pinxixi.controller.admin.vo.AdminUserVO;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.AdminUserToken;
import com.pinxixi.service.admin.AdminUserService;
import com.pinxixi.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public Result login(@RequestBody @Valid AdminUserLoginParam adminUserLoginParam) {
        AdminUserToken userToken = adminUserService.login(adminUserLoginParam.getUserName(), adminUserLoginParam.getPassword());

        if (userToken != null) {
            return Result.success(ServiceResultEnum.LOGIN_SUCCESS.getResult(), userToken);
        } else {
            return Result.fail(ServiceResultEnum.LOGIN_FAIL.getResult());
        }

    }

    /**
     * 退出登录
     * @param httpServletRequest
     * @return
     */
    @PostMapping("/logout")
    public Result logout(HttpServletRequest httpServletRequest) {
        Boolean logout = adminUserService.logout(httpServletRequest);
        if (logout) {
            return Result.success(ServiceResultEnum.LOGOUT_SUCCESS.getResult());
        } else {
            return Result.fail(ServiceResultEnum.LOGOUT_FAIL.getResult());
        }
    }

    /**
     * 用户信息
     * @param userId
     * @return
     */
    @ApiOperation("管理员信息")
    @GetMapping("/users/{userId}")
    public Result<AdminUserVO> getUserInfo(@PathVariable int userId) {
        AdminUser user = adminUserService.getUser(userId);
        if (user != null) {
            AdminUserVO adminUserVO = new AdminUserVO();
            BeanUtils.copyProperties(user, adminUserVO);
            return Result.success(adminUserVO);
        } else {
            return Result.fail(ServiceResultEnum.USER_NOT_FOUND.getResult());
        }
    }
}
