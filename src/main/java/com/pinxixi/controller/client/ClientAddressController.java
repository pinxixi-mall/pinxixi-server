package com.pinxixi.controller.client;

import com.pinxixi.common.Result;
import com.pinxixi.config.annotation.ClientUserArgument;
import com.pinxixi.controller.client.param.ClientAddressAddParam;
import com.pinxixi.controller.client.vo.ClientAddressVO;
import com.pinxixi.entity.ClientAddress;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.service.client.ClientAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "用户地址")
@RequestMapping("/client/address")
public class ClientAddressController {

    @Autowired
    private ClientAddressService addressService;

    /**
     * 用户地址列表
     * @param user
     * @return
     */
    @ApiOperation("用户地址列表")
    @GetMapping
    Result<List<ClientAddressVO>> getUserAddressList(@ClientUserArgument ClientUser user) {
        List<ClientAddress> addressList = addressService.getUserAddressList(user);
        List<ClientAddressVO> addressVOList = new ArrayList<>();
        for (ClientAddress address : addressList) {
            ClientAddressVO addressVO = new ClientAddressVO();
            BeanUtils.copyProperties(address, addressVO);
            addressVOList.add(addressVO);
        }

        return Result.success(addressVOList);
    }

    /**
     * 新增用户地址
     * @param addParam
     * @param user
     * @return
     */
    @ApiOperation("新增用户地址")
    @PostMapping
    Result addAddress(@RequestBody @Valid ClientAddressAddParam addParam, @ClientUserArgument ClientUser user){
        String result = addressService.addAddress(addParam, user);
        return Result.common(result);
    }

    /**
     * 查询用户地址
     * @param addressId
     * @return
     */
    @ApiOperation("新增用户地址")
    @GetMapping("/{addressId}")
    Result getAddress(@PathVariable Long addressId){
        ClientAddress address = addressService.getAddressById(addressId);
        if (address == null) {
            Result.fail("地址不存在");
        }
        return Result.success(address);
    }

}
