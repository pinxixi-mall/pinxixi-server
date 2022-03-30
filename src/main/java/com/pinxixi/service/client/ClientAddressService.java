package com.pinxixi.service.client;

import com.pinxixi.controller.client.param.ClientAddressAddParam;
import com.pinxixi.entity.ClientAddress;
import com.pinxixi.entity.ClientUser;

import java.util.List;

public interface ClientAddressService {

    String addAddress(ClientAddressAddParam addParam, ClientUser user);

    List<ClientAddress> getUserAddressList(ClientUser user);

    ClientAddress getAddressById(Long addressId);
}
