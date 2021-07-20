package com.example.rapidapply.services;

import com.example.rapidapply.commons.PublicProfileMapper;
import com.example.rapidapply.entity.PublicProfile;
import com.example.rapidapply.models.User;
import com.example.rapidapply.repository.PublicProfileRepository;
import com.example.rapidapply.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PublicProfileService {

    @Autowired
    private PublicProfileRepository publicProfileRepository;
    @Autowired
    private UserRepository userRepository;

    private static Logger LOGGER = LoggerFactory.getLogger(PublicProfileService.class);

    public User updatePublicProfile(User userModel) {
        try {
            com.example.rapidapply.entity.User userEntity = userRepository.getUserByEmail(userModel.getEmail());
            List<PublicProfile> publicProfileList = userEntity.getPublicProfileList();
            List<com.example.rapidapply.models.PublicProfile> publicProfileModelList = userModel.getPublicProfileList();

            for (com.example.rapidapply.models.PublicProfile publicProfileModel : publicProfileModelList) {
                PublicProfile publicProfile = PublicProfileMapper.modelToEntity(publicProfileModel);
                publicProfile.setUser(userEntity);
                publicProfileList.removeIf((i) -> i.getPlatformName().equals(publicProfile.getPlatformName()));
                publicProfileList.add(publicProfile);
            }

            userEntity.setPublicProfileList(publicProfileList);
            userRepository.save(userEntity);
            LOGGER.info("profiles have been successfully updated");
            return userModel;
        } catch (Exception exception) {
            LOGGER.error("An exception occurred while updatePublicProfile in PublicProfileService class",exception);
            return null;
        }
    }

    public Boolean deletePublicProfile(String publicProfileId){
        try {
            publicProfileRepository.deleteById(publicProfileId);
            LOGGER.info("The public profile is successfully deleted");
            return true;
        }catch (Exception exception){
            LOGGER.error("An exception occurred while deletePublicProfile in PublicProfileService class",exception);
            return false;
        }
    }
}
