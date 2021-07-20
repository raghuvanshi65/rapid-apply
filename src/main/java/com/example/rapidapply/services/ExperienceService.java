package com.example.rapidapply.services;

import com.example.rapidapply.commons.ExperienceMapper;
import com.example.rapidapply.entity.Achievements;
import com.example.rapidapply.entity.Experience;
import com.example.rapidapply.models.User;
import com.example.rapidapply.repository.ExperienceRepository;
import com.example.rapidapply.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class ExperienceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceService.class);

    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private UserRepository userRepository;

    public User updateExperiences(User userModel) {
        try {
            com.example.rapidapply.entity.User userEntity = userRepository.getUserByEmail(userModel.getEmail());
            List<Experience> experienceList = userEntity.getExperienceList();
            List<com.example.rapidapply.models.Experience> experienceModelList = userModel.getExperienceList();

            for (com.example.rapidapply.models.Experience experienceModel : experienceModelList) {
                Experience experienceEntity = ExperienceMapper.modelToEntity(experienceModel);
                experienceEntity.setUser(userEntity);
                if (experienceList.size() > 0)
                    experienceList.removeIf(i -> i.getOrgName().equals(experienceModel.getOrgName()) && i.getStartDate().equals(Date.valueOf(experienceModel.getStartDate())));
                experienceList.add(experienceEntity);
            }

            userEntity.setExperienceList(experienceList);
            userRepository.save(userEntity);
            LOGGER.info("experience has been updated");
            return userModel;
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while updateExperiences in ExperienceService class", exception);
            return null;
        }
    }

    public Boolean deleteExperience(String experienceId) {
        try {
            experienceRepository.deleteById(experienceId);
            LOGGER.info("The experience is successfully deleted");
            return true;
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while deleteExperience in ExperienceService class", exception);
            return false;
        }
    }
}
