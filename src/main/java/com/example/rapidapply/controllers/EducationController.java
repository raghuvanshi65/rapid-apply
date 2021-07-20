package com.example.rapidapply.controllers;

import com.example.rapidapply.models.*;
import com.example.rapidapply.services.EducationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/education")
public class EducationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EducationController.class);

    @Autowired
    private EducationService educationService;

    @RequestMapping(path = "/update" , method = RequestMethod.POST)
    public ResponseEntity<ResponseModel<Object>> updateEducation(@RequestBody User userModel){
        ResponseModel<Object> responseModel;
        try {
            List<Education> educationList = userModel.getEducationList();
            if (educationList == null || educationList.isEmpty()) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("The Field You are trying to add is empty")
                        .build();
                LOGGER.info("educationList is Empty");
                return ResponseEntity.status(400).body(responseModel);
            }
            User updatedUserModel = educationService.updateEducation(userModel);
            if(updatedUserModel==null){
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while updateEducation in EducationService class")
                        .build();
                LOGGER.info("Some exception occurred while updateEducation in EducationService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully").body(updatedUserModel)
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        }catch (Exception exception){
            LOGGER.error("An exception occurred while updateEducation in EducationController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while updateEducation in EducationController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }

    @RequestMapping(path = "/delete/{educationId}" ,method = RequestMethod.DELETE)
    public ResponseEntity<ResponseModel<Object>> deleteEducation(@PathVariable("educationId") String educationId){
        ResponseModel<Object> responseModel;
        try {
            if (educationId == null) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("The Field You are trying to delete is empty")
                        .build();
                LOGGER.info("publicProfileId is Empty");
                return ResponseEntity.status(400).body(responseModel);
            }
            Boolean isDeleted = educationService.deleteEducation(educationId);
            if(!isDeleted){
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while deleteEducation in EducationService class")
                        .build();
                LOGGER.info("Some exception occurred while deleteEducation in EducationService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully")
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        }catch (Exception exception){
            LOGGER.error("An exception occurred while deleteEducation in EducationController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while deleteEducation in EducationController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }
}
