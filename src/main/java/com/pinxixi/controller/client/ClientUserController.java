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
import com.pinxixi.controller.client.param.ClientUserRegisterParam;
import com.pinxixi.controller.client.param.ClientUserUpdateParam;
import com.pinxixi.controller.client.vo.ClientUserVO;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.entity.AdminUserToken;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.entity.TokenObj;
import com.pinxixi.service.client.ClientUserService;
import com.pinxixi.utils.PinXiXiUtils;
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
@RequestMapping("/client/user")
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
     * 注册
     * @param registerParam
     * @return
     */
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result login(@RequestBody @Valid ClientUserRegisterParam registerParam) {
        String result = clientUserService.register(registerParam);
        if (result != null) {
            return Result.success(ServiceResultEnum.REGISTER_SUCCESS.getResult());
        } else {
            return Result.fail(ServiceResultEnum.REGISTER_FAIL.getResult());
        }
    }

    /**
     * 退出登录
     * @param httpServletRequest
     * @return
     */
    @PostMapping("/logout")
    public Result logout(HttpServletRequest httpServletRequest) {
        Boolean logout = clientUserService.logout(httpServletRequest);
        if (logout) {
            return Result.success(ServiceResultEnum.LOGOUT_SUCCESS.getResult());
        } else {
            return Result.fail(ServiceResultEnum.LOGOUT_FAIL.getResult());
        }
    }

    /**
     * 用户信息
     * @param user
     * @return
     */
    @ApiOperation("用户信息")
    @GetMapping
    public Result<ClientUserVO> userInfo(@ClientUserArgument ClientUser user) {
        ClientUser userInfo = clientUserService.userInfo(user);
        ClientUserVO clientUserVO = new ClientUserVO();
        BeanUtils.copyProperties(userInfo, clientUserVO);
        return Result.success(clientUserVO);
    }

    /**
     * 修改用户信息
     * @param updateParam
     * @return
     */
    @ApiOperation("修改用户信息")
    @PutMapping
    public Result updateUserInfo(@RequestBody @Valid ClientUserUpdateParam updateParam, @ClientUserArgument ClientUser user) {
        Integer rows = clientUserService.updateUserInfo(updateParam, user);
        return Result.common(PinXiXiUtils.genSqlResultByRows(rows));
    }

}
