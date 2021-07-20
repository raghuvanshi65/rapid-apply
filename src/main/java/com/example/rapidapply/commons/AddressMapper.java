package com.example.rapidapply.commons;

import com.example.rapidapply.entity.Address;

import java.util.UUID;

public class AddressMapper {
    public static Address modelToEntity(com.example.rapidapply.models.Address addressModel) {
        Address address = new Address();

        address.setAddressId(addressModel.getAddressId() == null ? UUID.randomUUID().toString() : addressModel.getAddressId().toString());

        if (addressModel.getAddressId() != null)
            address.setAddressId(addressModel.getAddressId().toString());
        address.setAddressLine(addressModel.getAddressLine());
        address.setCity(addressModel.getCity());
        address.setState(addressModel.getState());
        address.setCountry(addressModel.getCountry());
        return address;
    }
}
