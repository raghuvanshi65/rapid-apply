package com.example.rapidapply.services;

import com.example.rapidapply.commons.AchievementMapper;
import com.example.rapidapply.entity.Achievements;
import com.example.rapidapply.models.User;
import com.example.rapidapply.repository.AchievementsRepository;
import com.example.rapidapply.repository.AddressRepository;
import com.example.rapidapply.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AchievementService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AchievementService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AchievementsRepository achievementsRepository;

    public User updateAchievements(User userModel) {
        try {
            com.example.rapidapply.entity.User userEntity = userRepository.getUserByEmail(userModel.getEmail());
            List<Achievements> achievementsList = userEntity.getAchievementsList();
            List<com.example.rapidapply.models.Achievements> achievementsModelList = userModel.getAchievementsList();

            for (com.example.rapidapply.models.Achievements achievementModel : achievementsModelList) {
                Achievements achievementEntity = AchievementMapper.modelToEntity(achievementModel);
                achievementEntity.setUser(userEntity);
                achievementsList.removeIf(i->i.getHeading().equals(achievementModel.getHeading()));
                achievementsList.add(achievementEntity);
            }

            userEntity.setAchievementsList(achievementsList);
            userRepository.save(userEntity);
            LOGGER.info("Achievements are successfully updated");
            return userModel;
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while updateAchievements in AchievementService class",exception);
            return null;
        }
    }


    public Boolean deleteAchievement(String achievementId){
        try {
            achievementsRepository.deleteById(achievementId);
            LOGGER.info("The achievement is successfully deleted");
            return true;
        }catch (Exception exception){
            LOGGER.error("An exception occurred while deleteAchievement in AchievementService class",exception);
            return false;
        }
    }
}
