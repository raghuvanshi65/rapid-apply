package com.example.rapidapply.controllers;

import com.example.rapidapply.models.Experience;
import com.example.rapidapply.models.ImmutableResponseModel;
import com.example.rapidapply.models.ResponseModel;
import com.example.rapidapply.models.User;
import com.example.rapidapply.services.ExperienceService;
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
@RequestMapping(path = "/exp")
public class ExperienceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceController.class);

    @Autowired
    private ExperienceService experienceService;

    @RequestMapping(path = "/update" , method = RequestMethod.POST)
    public ResponseEntity<ResponseModel<Object>> updateExperiences(@RequestBody User userModel){
        ResponseModel<Object> responseModel;
        try {
            List<Experience> experienceList = userModel.getExperienceList();
            if(experienceList==null || experienceList.isEmpty()){
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("The field you are trying to update is empty , Bad Request")
                        .build();
                return ResponseEntity.status(400).body(responseModel);
            }
            User updatedUser = experienceService.updateExperiences(userModel);
            if(updatedUser==null){
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while updateExperiences in experienceService class")
                        .build();
                LOGGER.info("Some exception occurred while updateExperiences in experienceService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully").body(updatedUser)
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        }catch (Exception exception){
            LOGGER.error("An exception occurred while updateExperiences in ExperienceController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while updateExperiences in ExperienceController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }


    @RequestMapping(path = "/delete/{experienceId}" ,method = RequestMethod.DELETE)
    public ResponseEntity<ResponseModel<Object>> deleteExperience(@PathVariable("experienceId") String experienceId) {
        ResponseModel<Object> responseModel;
        try {
            if (experienceId == null) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("The Field You are trying to delete is empty")
                        .build();
                LOGGER.info("ExperienceId is Empty");
                return ResponseEntity.status(400).body(responseModel);
            }
            Boolean isDeleted = experienceService.deleteExperience(experienceId);
            if (!isDeleted) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while deleteExperience in experienceService class")
                        .build();
                LOGGER.info("Some exception occurred while deleteExperience in experienceService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully")
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while deleteExperience in ExperienceController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while deleteExperience in ExperienceController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }
}
