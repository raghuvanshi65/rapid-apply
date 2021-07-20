package com.example.rapidapply.controllers;


import com.example.rapidapply.models.*;
import com.example.rapidapply.services.SkillsService;
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
@RequestMapping(path = "/skills")
public class SkillsController {

    private static Logger LOGGER = LoggerFactory.getLogger(SkillsController.class);

    @Autowired
    private SkillsService skillsService;

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<ResponseModel<Object>> updateSkills(@RequestBody User userModel) {
        ResponseModel<Object> responseModel;
        try {
            List<Skills> skillsList = userModel.getSkillsList();
            if (skillsList == null || skillsList.isEmpty()) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("The Field You are trying to add is empty")
                        .build();
                LOGGER.info("skillsList is Empty");
                return ResponseEntity.status(400).body(responseModel);
            }
            User updatedUser = skillsService.updateSkills(userModel);
            if (updatedUser == null) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while updateSkills in SkillsService class")
                        .build();
                LOGGER.info("Some exception occurred while updateSkills in SkillsService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully").body(updatedUser)
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while updateSkills in SkillsController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while updateSkills in SkillsController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }



    @RequestMapping(path = "/delete/{skillId}" ,method = RequestMethod.DELETE)
    public ResponseEntity<ResponseModel<Object>> deleteSkill(@PathVariable("skillId") String skillId) {
        ResponseModel<Object> responseModel;
        try {
            if (skillId == null) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("The Field You are trying to delete is empty")
                        .build();
                LOGGER.info("skillId is Empty");
                return ResponseEntity.status(400).body(responseModel);
            }
            Boolean isDeleted = skillsService.deleteSkill(skillId);
            if (!isDeleted) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while deleteSkill in SkillsService class")
                        .build();
                LOGGER.info("Some exception occurred while deleteSkill in SkillsService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully")
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while deleteSkill in SkillsController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while deleteSkill in SkillsController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }
}
