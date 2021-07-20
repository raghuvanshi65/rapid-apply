package com.example.rapidapply.controllers;

import com.example.rapidapply.config.RapidApplyConfiguration;
import com.example.rapidapply.models.*;
import com.example.rapidapply.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private RapidApplyConfiguration rapidApplyConfiguration;

    @Autowired
    private UserService userService;

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(path = "/signup" , method = RequestMethod.POST)
    public ResponseEntity<ResponseModel<Object>> userSignUp(@RequestBody UserSignUp userSignUp){
        ResponseModel<Object> responseModel;
        try {
            Boolean isCreated = userService.userSignUp(userSignUp);
            if(!isCreated){
                 responseModel = ImmutableResponseModel.builder().accepted(false)
                                    .message("Some exception occurred while userSignUp in UserService class")
                                    .build();
                LOGGER.info("Some exception occurred while userSignUp in UserService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("user is created successfully")
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        }catch (Exception exception){
            LOGGER.error("An exception occurred while userSignUp in UserController class",exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while userSignUp in UserController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }

    @RequestMapping(path = "/basic",method = RequestMethod.PUT)
    public ResponseEntity<ResponseModel<Object>> updateUser(@RequestBody User user){
        ResponseModel<Object> responseModel;
        try {
            UserPublic userPublic = userService.updateUser(user);
            if(userPublic==null){
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while userSignUp in UserService class")
                        .build();
                LOGGER.info("Some exception occurred while updateUser in UserService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("user is updated successfully").body(userPublic)
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        }catch (Exception exception){
            LOGGER.error("An exception occurred while updateUser in UserController class",exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while updateUser in UserController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }
}
