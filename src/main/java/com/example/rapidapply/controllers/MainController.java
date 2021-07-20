package com.example.rapidapply.controllers;

import com.example.rapidapply.RapidApplyApplication;
import com.example.rapidapply.models.ImmutableResponseModel;
import com.example.rapidapply.models.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private static Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    RapidApplyApplication rapidApplyApplication;

    @RequestMapping(path = "/main/check", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel<Object>> getResponse() {
        LOGGER.info("The controller is working successfully !!");
        ResponseModel<Object> responseModel = ImmutableResponseModel.builder().accepted(true)
                                        .message("The controller is working successfully").build();

        return ResponseEntity.ok().body(responseModel);
    }
}
