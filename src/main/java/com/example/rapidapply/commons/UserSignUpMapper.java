package com.example.rapidapply.commons;

import com.example.rapidapply.entity.User;
import com.example.rapidapply.models.UserSignUp;

import java.util.UUID;

public class UserSignUpMapper {
    public static User UserSignUpToUserEntity(UserSignUp userSignUp){
        User userEntity = new User();
        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setEmail(userSignUp.getEmail());
        userEntity.setPassword(userSignUp.getPassword());
        return userEntity;
    }
}
