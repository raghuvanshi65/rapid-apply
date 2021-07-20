package com.example.rapidapply.commons;

import com.example.rapidapply.entity.User;
import com.example.rapidapply.models.ImmutableUserPublic;
import com.example.rapidapply.models.UserPublic;

import java.util.UUID;

public class UserPublicMapper {
    public static UserPublic UserEntityToModel(User userEntity){
        return ImmutableUserPublic.builder().id(UUID.fromString(userEntity.getUserId()))
                                            .email(userEntity.getEmail())
                                            .fullname(userEntity.getFullname())
                                            .phone(userEntity.getPhone())
                                            .build();
    }
}
