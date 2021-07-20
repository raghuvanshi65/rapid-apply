package com.example.rapidapply.services;

import com.example.rapidapply.commons.AddressMapper;
import com.example.rapidapply.models.Address;
import com.example.rapidapply.models.User;
import com.example.rapidapply.repository.AddressRepository;
import com.example.rapidapply.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressService {

    private static Logger LOGGER = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    public Address updateUserWithAddress(Address address){
        try {
            com.example.rapidapply.entity.Address existingAddress = addressRepository.getAddressByUser_UserId(address.getUserId().toString());
            if(existingAddress==null) {
                com.example.rapidapply.entity.User userEntity = userRepository.getById(address.getUserId().toString());
                com.example.rapidapply.entity.Address addressEntity = AddressMapper.modelToEntity(address);
                addressEntity.setUser(userEntity);
                userEntity.setAddress(addressEntity);

                userRepository.save(userEntity);
                addressRepository.save(addressEntity);
                LOGGER.info("The user with id: " + address.getUserId() + " is updated with address");
                return address;
            }
            existingAddress.setAddressLine(address.getAddressLine());
            existingAddress.setCountry(address.getCountry());
            existingAddress.setCity(address.getCity());
            existingAddress.setState(address.getState());

            addressRepository.save(existingAddress);
            return address;
        }catch (Exception exception){
            LOGGER.error("An exception occurred while updateUserWithAddress in AddressService class",exception);
            return null;
        }
    }
}
