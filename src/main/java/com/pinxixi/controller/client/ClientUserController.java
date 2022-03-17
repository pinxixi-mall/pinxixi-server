package com.pinxixi.controller.client;

import com.pinxixi.common.Result;
import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.config.annotation.ClientUserArgument;
import com.pinxixi.controller.admin.param.AdminUserLoginParam;
import com.pinxixi.controller.admin.param.AdminUserPwdResetParam;
import com.pinxixi.controller.admin.param.AdminUserUpdateParam;
import com.pinxixi.controller.admin.vo.AdminUserVO;
import com.pinxixi.controller.client.param.ClientUserLoginParam;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.AdminUserToken;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.entity.TokenObj;
import com.pinxixi.service.client.ClientUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 客户端-用户
 */
@Api(value = "v1.0.0", tags = "用户管理")
@RestController
@RequestMapping("/client")
public class ClientUserController {

    @Autowired
    private ClientUserService clientUserService;

    /**
     * 登录
     * @param loginParam
     * @return
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody @Valid ClientUserLoginParam loginParam) {
        TokenObj userToken = clientUserService.login(loginParam.getUserName(), loginParam.getPassword());

        if (userToken != null) {
            return Result.success(ServiceResultEnum.LOGIN_SUCCESS.getResult(), userToken);
        } else {
            return Result.fail(ServiceResultEnum.LOGIN_FAIL.getResult());
        }

    }

    /**
     * 退出登录
     * @param clientUser
     * @return
     */
    @PostMapping("/logout")
    public Result logout(@ClientUserArgument ClientUser clientUser) {
        Boolean logout = clientUserService.logout(clientUser);
        if (logout) {
            return Result.success(ServiceResultEnum.LOGOUT_SUCCESS.getResult());
        } else {
            return Result.fail(ServiceResultEnum.LOGOUT_FAIL.getResult());
        }
    }



}
