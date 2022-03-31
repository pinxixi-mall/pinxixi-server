package com.pinxixi.service.client.impl;

import com.pinxixi.controller.client.param.ClientAddressAddParam;
import com.pinxixi.controller.client.param.ClientAddressUpdateParam;
import com.pinxixi.dao.ClientAddressMapper;
import com.pinxixi.entity.ClientAddress;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.service.client.ClientAddressService;
import com.pinxixi.utils.PinXiXiUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.Valid;
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

    /**
     * 更新地址
     * @param updateParam
     * @return
     */
    @Override
    public Integer updateAddress(@Valid ClientAddressUpdateParam updateParam) {
        ClientAddress address = new ClientAddress();
        BeanUtils.copyProperties(updateParam, address);
        if (address.getIsDefault() == 1) {
            //如果要设置当前为默认地址，需要将其他地址设置为非默认
            addressMapper.resetDefaultAddress();
        }
        Integer rows = addressMapper.updateAddress(address);
        return rows;
    }

    /**
     * 默认地址
     * @param user
     * @return
     */
    @Override
    public ClientAddress getDefaultAddress(ClientUser user) {
        ClientAddress address = addressMapper.selectDefaultAddress(user.getUserId());
        return address;
    }

    /**
     * 删除地址
     * @param addressId
     * @return
     */
    @Override
    public Integer deleteAddress(Long addressId) {
        Integer rows = addressMapper.deleteAddress(addressId);
        return rows;
    }

}
