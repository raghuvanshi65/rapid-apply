package com.example.rapidapply.commons;

import com.example.rapidapply.entity.Address;
import com.example.rapidapply.models.ImmutableAddress;

import java.util.Locale;
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
        address.setHidden(addressModel.getHidden()==null ? "NO" : addressModel.getHidden().trim().toUpperCase(Locale.ROOT));
        return address;
    }

    public static com.example.rapidapply.models.Address entityToModel(Address addressEntity){
        return ImmutableAddress.builder().userId(UUID.fromString(addressEntity.getUser().getUserId())).addressId(UUID.fromString(addressEntity.getAddressId()))
                .addressLine(addressEntity.getAddressLine()).city(addressEntity.getCity())
                .state(addressEntity.getState()).country(addressEntity.getCountry())
                .hidden(addressEntity.getHidden()).build();
    }
}
