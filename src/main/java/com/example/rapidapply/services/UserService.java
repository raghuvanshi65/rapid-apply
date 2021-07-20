package com.example.rapidapply.services;

import com.example.rapidapply.commons.UserMapper;
import com.example.rapidapply.commons.UserPublicMapper;
import com.example.rapidapply.commons.UserSignUpMapper;
import com.example.rapidapply.entity.User;
import com.example.rapidapply.models.UserPublic;
import com.example.rapidapply.models.UserSignUp;
import com.example.rapidapply.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public Boolean userSignUp(UserSignUp userSignUp){
        try {
            User user = UserSignUpMapper.UserSignUpToUserEntity(userSignUp);
            userRepository.save(user);
            LOGGER.info("user with id : "+user.getUserId()+" is created successfully");
            return true;
        }catch (Exception exception){
            LOGGER.error("An exception occurred while userSignUp in UserService class",exception);
            return false;
        }
    }

    public UserPublic updateUser(com.example.rapidapply.models.User userModel){
        try {
            User userEntity = userModelToEntity(userModel);
            userRepository.save(userEntity);
            LOGGER.info("user with id : "+userEntity.getUserId()+" is created successfully");
            return UserPublicMapper.UserEntityToModel(userEntity);
        }catch (Exception exception){
            LOGGER.error("An exception occurred while updateUser in UserService class",exception);
            return null;
        }
    }

    public com.example.rapidapply.models.User getAll(String email){
        try {
            User userEntity = userRepository.getUserByEmail(email);
            LOGGER.info("user details retrieved successfully");
            return UserMapper.userEntityToModel(userEntity);
        }catch (Exception exception){
            LOGGER.error("An exception occurred while getAll in UserService class",exception);
            return null;
        }
    }

    /**
     * commons method
     */
    private User userModelToEntity(com.example.rapidapply.models.User userModel){
        User userEntity = userRepository.getUserByEmail(userModel.getEmail());
        userEntity.setFullname(userModel.getFullname());
        userEntity.setPhone(userModel.getPhone());

        return userEntity;
    }
}
