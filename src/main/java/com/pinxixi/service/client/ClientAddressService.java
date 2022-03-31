package com.pinxixi.service.client;

import com.pinxixi.controller.client.param.ClientAddressAddParam;
import com.pinxixi.controller.client.param.ClientAddressUpdateParam;
import com.pinxixi.entity.ClientAddress;
import com.pinxixi.entity.ClientUser;

import javax.validation.Valid;
import java.util.List;

public interface ClientAddressService {

    String addAddress(ClientAddressAddParam addParam, ClientUser user);

    List<ClientAddress> getUserAddressList(ClientUser user);

    ClientAddress getAddressById(Long addressId);

    Integer deleteAddress(Long addressId);

    Integer updateAddress(@Valid ClientAddressUpdateParam addressId);

    ClientAddress getDefaultAddress(ClientUser user);
}
