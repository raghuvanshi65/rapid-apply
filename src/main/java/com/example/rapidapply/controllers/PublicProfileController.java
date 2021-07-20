package com.example.rapidapply.controllers;

import com.example.rapidapply.models.ImmutableResponseModel;
import com.example.rapidapply.models.PublicProfile;
import com.example.rapidapply.models.ResponseModel;
import com.example.rapidapply.models.User;
import com.example.rapidapply.services.PublicProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/publicprofile")
public class PublicProfileController {

    private static Logger LOGGER = LoggerFactory.getLogger(PublicProfileController.class);

    @Autowired
    private PublicProfileService publicProfileService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<ResponseModel<Object>> updatePublicProfile(@RequestBody User userModel) {
        ResponseModel<Object> responseModel;
        try {
            List<PublicProfile> publicProfileList = userModel.getPublicProfileList();
            if (publicProfileList == null || publicProfileList.isEmpty()) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("The Field You are trying to add is empty")
                        .build();
                LOGGER.info("publicProfileList is Empty");
                return ResponseEntity.status(400).body(responseModel);
            }
            User updatedUserModel = publicProfileService.updatePublicProfile(userModel);
            if (updatedUserModel == null) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while updatePublicProfile in PublicProfileService class")
                        .build();
                LOGGER.info("Some exception occurred while updatePublicProfile in PublicProfileService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully").body(updatedUserModel)
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while updatePublicProfile in PublicProfileController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while updatePublicProfile in PublicProfileController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }

    @RequestMapping(path = "/delete/{publicProfileId}" ,method = RequestMethod.DELETE)
    public ResponseEntity<ResponseModel<Object>> deletePublicProfile(@PathVariable("publicProfileId") String publicProfileId) {
        ResponseModel<Object> responseModel;
        try {
            if (publicProfileId == null) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("The Field You are trying to delete is empty")
                        .build();
                LOGGER.info("publicProfileId is Empty");
                return ResponseEntity.status(400).body(responseModel);
            }
            Boolean isDeleted = publicProfileService.deletePublicProfile(publicProfileId);
            if (!isDeleted) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while deletePublicProfile in PublicProfileService class")
                        .build();
                LOGGER.info("Some exception occurred while deletePublicProfile in PublicProfileService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully")
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while deletePublicProfile in PublicProfileController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while deletePublicProfile in PublicProfileController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }
}
