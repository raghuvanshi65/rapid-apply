package com.example.rapidapply.controllers;

import com.example.rapidapply.models.Address;
import com.example.rapidapply.models.ImmutableResponseModel;
import com.example.rapidapply.models.ResponseModel;
import com.example.rapidapply.services.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/address")
public class AddressController {

    private static Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @Transactional
    @RequestMapping(path = "/update" , method = RequestMethod.POST)
    public ResponseEntity<ResponseModel<Object>> updateAddress(@RequestBody Address address){
        ResponseModel<Object> responseModel;
        try {
            Address addressUpdated = addressService.updateUserWithAddress(address);
            if(addressUpdated==null){
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while updateAddress in AddressService class")
                        .build();
                LOGGER.info("Some exception occurred while updateAddress in AddressService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully").body(address)
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        }catch (Exception exception){
            LOGGER.error("An exception occurred while updateAddress in AddressController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while updateAddress in AddressController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }
}
