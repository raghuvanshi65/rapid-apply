package com.example.rapidapply.controllers;

import com.example.rapidapply.models.*;
import com.example.rapidapply.services.AchievementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/achieve")
public class AchievementsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AchievementsController.class);

    @Autowired
    private AchievementService achievementService;

    @RequestMapping(path = "/update" , method = RequestMethod.POST)
    public ResponseEntity<ResponseModel<Object>> updateAchievements(@RequestBody User userModel){
        ResponseModel<Object> responseModel;
        try {
            List<Achievements> achievementsList = userModel.getAchievementsList();
            if(achievementsList==null || achievementsList.isEmpty()){
                responseModel = ImmutableResponseModel.builder().accepted(false)
                                                                .message("The field you are trying to update is empty , Bad Request")
                                                                .build();
                return ResponseEntity.status(400).body(responseModel);
            }
            User updatedUser = achievementService.updateAchievements(userModel);
            if(updatedUser==null){
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while updateAchievements in AchievementService class")
                        .build();
                LOGGER.info("Some exception occurred while updateAchievements in AchievementService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully").body(updatedUser)
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        }catch (Exception exception){
            LOGGER.error("An exception occurred while updateAchievements in AchievementsController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while updateAchievements in AchievementsController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }


    @RequestMapping(path = "/delete/{achievementId}" ,method = RequestMethod.DELETE)
    public ResponseEntity<ResponseModel<Object>> deleteAchievement(@PathVariable("achievementId") String achievementId) {
        ResponseModel<Object> responseModel;
        try {
            if (achievementId == null) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("The Field You are trying to delete is empty")
                        .build();
                LOGGER.info("achievementId is Empty");
                return ResponseEntity.status(400).body(responseModel);
            }
            Boolean isDeleted = achievementService.deleteAchievement(achievementId);
            if (!isDeleted) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while deleteAchievement in AchievementService class")
                        .build();
                LOGGER.info("Some exception occurred while deleteAchievement in AchievementService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully")
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while deleteAchievement in AchievementsController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while deleteAchievement in AchievementsController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }
}
