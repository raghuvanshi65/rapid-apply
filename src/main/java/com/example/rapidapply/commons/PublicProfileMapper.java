package com.example.rapidapply.commons;

import com.example.rapidapply.entity.PublicProfile;

import java.util.Locale;
import java.util.UUID;

public class PublicProfileMapper {
    public static PublicProfile modelToEntity(com.example.rapidapply.models.PublicProfile publicProfileModel){
        PublicProfile publicProfileEntity = new PublicProfile();
        publicProfileEntity.setPublicProfileId(publicProfileModel.getId()==null ? UUID.randomUUID().toString() : publicProfileModel.getId().toString());
        publicProfileEntity.setPlatformName(publicProfileModel.getPlatformName().trim().toLowerCase(Locale.ROOT));
        publicProfileEntity.setPlatformLink(publicProfileModel.getProfileLink().trim());
        return publicProfileEntity;
    }
}
