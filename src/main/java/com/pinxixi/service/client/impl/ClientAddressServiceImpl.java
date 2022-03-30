package com.pinxixi.service.client.impl;

import com.pinxixi.controller.client.param.ClientAddressAddParam;
import com.pinxixi.dao.ClientAddressMapper;
import com.pinxixi.entity.ClientAddress;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.service.client.ClientAddressService;
import com.pinxixi.utils.PinXiXiUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientAddressServiceImpl implements ClientAddressService {

    @Resource
    private ClientAddressMapper addressMapper;

    /**
     * 新增用户地址
     * @param addParam
     * @param user
     * @return
     */
    @Override
    public String addAddress(ClientAddressAddParam addParam, ClientUser user) {
        ClientAddress clientAddress = new ClientAddress();
        BeanUtils.copyProperties(addParam, clientAddress);
        clientAddress.setUserId(user.getUserId());
        Integer rows = addressMapper.insertAddress(clientAddress);
        return PinXiXiUtils.genSqlResultByRows(rows);
    }

    /**
     * 用户地址列表
     * @param user
     * @return
     */
    @Override
    public List<ClientAddress> getUserAddressList(ClientUser user) {
        List<ClientAddress> addressList = addressMapper.selectAddressByUserId(user.getUserId());
        return addressList;
    }

    /**
     * 用户地址
     * @param addressId
     * @return
     */
    @Override
    public ClientAddress getAddressById(Long addressId) {
        ClientAddress address = addressMapper.selectAddressByAddressId(addressId);
        return address;
    }

}
