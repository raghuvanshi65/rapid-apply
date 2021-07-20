package com.example.rapidapply.controllers;

import com.example.rapidapply.models.*;
import com.example.rapidapply.services.ProjectService;
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
@RequestMapping("/projects")
public class ProjectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;

    @RequestMapping(path = "/update" , method = RequestMethod.POST)
    public ResponseEntity<ResponseModel<Object>> updateProjects(@RequestBody User userModel){
        ResponseModel<Object> responseModel;
        try {
            List<Projects> projectsList = userModel.getProjectsList();
            if (projectsList == null || projectsList.isEmpty()) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("The Field You are trying to add is empty")
                        .build();
                LOGGER.info("projectsList is Empty");
                return ResponseEntity.status(400).body(responseModel);
            }
            User updatedUserModel = projectService.updateProjects(userModel);
            if (updatedUserModel == null) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while updateProjects in projectService class")
                        .build();
                LOGGER.info("Some exception occurred while updateProjects in projectService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully").body(updatedUserModel)
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while updateProjects in ProjectController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while updateProjects in ProjectController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }

    @RequestMapping(path = "/delete/{projectId}" ,method = RequestMethod.DELETE)
    public ResponseEntity<ResponseModel<Object>> deleteProject(@PathVariable("projectId") String projectId) {
        ResponseModel<Object> responseModel;
        try {
            if (projectId == null) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("The Field You are trying to delete is empty")
                        .build();
                LOGGER.info("projectId is Empty");
                return ResponseEntity.status(400).body(responseModel);
            }
            Boolean isDeleted = projectService.deleteProject(projectId);
            if (!isDeleted) {
                responseModel = ImmutableResponseModel.builder().accepted(false)
                        .message("Some exception occurred while deleteProject in projectService class")
                        .build();
                LOGGER.info("Some exception occurred while deleteProject in projectService class");
                return ResponseEntity.status(500).body(responseModel);
            }
            responseModel = ImmutableResponseModel.builder().accepted(true)
                    .message("user is updated successfully")
                    .build();
            return ResponseEntity.status(200).body(responseModel);
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while deleteProject in ProjectController class", exception);
            responseModel = ImmutableResponseModel.builder().accepted(false)
                    .message("Some exception occurred while deleteProject in ProjectController class")
                    .build();
            return ResponseEntity.status(500).body(responseModel);
        }
    }
}
