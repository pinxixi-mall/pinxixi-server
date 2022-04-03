package com.pinxixi.controller.admin;

import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.controller.admin.param.AdminUserLoginParam;
import com.pinxixi.controller.admin.param.UserPwdResetParam;
import com.pinxixi.controller.admin.param.AdminUserUpdateParam;
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
@Api(value = "v1.0.0", tags = "用户管理")
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
     * 根据userId查询用户信息
     * @param userId
     * @return
     */
    @ApiOperation("根据userId查询管理员信息")
    @GetMapping("/user/{userId}")
    public Result<AdminUserVO> userInfo(@PathVariable int userId) {
        AdminUser user = adminUserService.getUser(userId);
        if (user != null) {
            AdminUserVO adminUserVO = new AdminUserVO();
            BeanUtils.copyProperties(user, adminUserVO);
            return Result.success(adminUserVO);
        } else {
            return Result.fail(ServiceResultEnum.USER_NOT_FOUND.getResult());
        }
    }

    /**
     * 管理员信息
     * @param adminUser
     * @return
     */
    @ApiOperation("管理员信息")
    @GetMapping("/user")
    public Result<AdminUserVO> userInfo(@AdminUserArgument AdminUser adminUser) {
        AdminUserVO adminUserVO = new AdminUserVO();
        BeanUtils.copyProperties(adminUser, adminUserVO);
        return Result.success(adminUserVO);
    }

    /**
     * 修改用户信息
     * @param updateParam
     * @param adminUser
     * @return
     */
    @ApiOperation("修改用户信息")
    @PutMapping("/user")
    public Result updateUserInfo(@RequestBody @Valid AdminUserUpdateParam updateParam, @AdminUserArgument AdminUser adminUser) {
        AdminUser user = new AdminUser();
        user.setUserId(adminUser.getUserId());
        BeanUtils.copyProperties(updateParam, user);

        String result = adminUserService.updateUserInfo(user);
        return Result.common(result);
    }

    /**
     * 重置密码
     * @param resetParam
     * @param adminUser
     * @return
     */
    @ApiOperation("重置密码")
    @PutMapping("/user/reset")
    public Result resetPassword(@RequestBody @Valid UserPwdResetParam resetParam, @AdminUserArgument AdminUser adminUser) {
        String result = adminUserService.restPassword(resetParam, adminUser);
        if (result.equals(ServiceResultEnum.WRONG_OLD_PASSWORD.getResult()) || result.equals(ServiceResultEnum.PASSWORD_INCONSISTENT.getResult())) {
            return Result.fail(result);
        }
        return Result.success(result);
    }

}
