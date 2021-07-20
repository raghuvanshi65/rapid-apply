package com.example.rapidapply.services;

import com.example.rapidapply.commons.ProjectsMapper;
import com.example.rapidapply.commons.PublicProfileMapper;
import com.example.rapidapply.entity.Projects;
import com.example.rapidapply.entity.PublicProfile;
import com.example.rapidapply.models.User;
import com.example.rapidapply.repository.ProjectRepository;
import com.example.rapidapply.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    public User updateProjects(User userModel){
        try {
            com.example.rapidapply.entity.User userEntity = userRepository.getUserByEmail(userModel.getEmail());
            List<Projects> projectList = userEntity.getProjectsList();
            List<com.example.rapidapply.models.Projects> projectModelList = userModel.getProjectsList();

            for (com.example.rapidapply.models.Projects projectModel : projectModelList) {
                Projects projectEntity = ProjectsMapper.modelToEntity(projectModel);
                projectEntity.setUser(userEntity);
                projectList.removeIf((i) -> i.getProjectName().equals(projectModel.getProjectName()));
                projectList.add(projectEntity);
            }

            userEntity.setProjectsList(projectList);
            userRepository.save(userEntity);
            LOGGER.info("projects have been successfully updated");
            return userModel;
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while updateProjects in ProjectService class",exception);
            return null;
        }
    }


    public Boolean deleteProject(String projectId){
        try {
            projectRepository.deleteById(projectId);
            LOGGER.info("The project is successfully deleted");
            return true;
        }catch (Exception exception){
            LOGGER.error("An exception occurred while deleteProject in ProjectService class",exception);
            return false;
        }
    }
}
