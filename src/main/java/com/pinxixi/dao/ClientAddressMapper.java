package com.pinxixi.dao;

import com.pinxixi.entity.ClientAddress;

import java.util.List;

public interface ClientAddressMapper {

    Integer insertAddress(ClientAddress address);

    Integer updateAddress(ClientAddress address);

    List<ClientAddress> selectAddressByUserId(Integer userId);

    ClientAddress selectAddressByAddressId(Long addressId);

}
