package com.example.rapidapply.services;

import com.example.rapidapply.commons.EducationMapper;
import com.example.rapidapply.controllers.EducationController;
import com.example.rapidapply.entity.Education;
import com.example.rapidapply.models.User;
import com.example.rapidapply.repository.EducationRepository;
import com.example.rapidapply.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EducationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EducationController.class);

    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private UserRepository userRepository;

    public User updateEducation(User userModel){
        try {
            com.example.rapidapply.entity.User userEntity = userRepository.getUserByEmail(userModel.getEmail());
            List<Education> educationList = userEntity.getEducationList();
            List<com.example.rapidapply.models.Education> educationModelList = userModel.getEducationList();

            for(com.example.rapidapply.models.Education educationModel : educationModelList){
                Education education = EducationMapper.modelToEntity(educationModel);
                education.setUser(userEntity);
                educationList.removeIf(i->i.getAcademicLevel().equals(educationModel.getAcademicLevel()));
                educationList.add(education);
            }

            userEntity.setEducationList(educationList);
            userRepository.save(userEntity);
            LOGGER.info("education have been successfully updated");
            return userModel;
        }catch (Exception exception){
            LOGGER.error("An exception occurred while updateEducation in EducationService class",exception);
            return null;
        }
    }

    public Boolean deleteEducation(String educationId){
        try {
            educationRepository.deleteById(educationId);
            LOGGER.info("The education is successfully deleted");
            return true;
        }catch (Exception exception){
            LOGGER.error("An exception occurred while deleteEducation in EducationService class",exception);
            return false;
        }
    }
}
