package com.example.rapidapply.commons;

import com.example.rapidapply.entity.Achievements;

import java.util.UUID;

public class AchievementMapper {
    public static Achievements modelToEntity(com.example.rapidapply.models.Achievements achievementModel){
        Achievements achievements = new Achievements();
        if(achievementModel.getAchId()==null)
            achievements.setAchId(UUID.randomUUID().toString());
        else
            achievements.setAchId(achievementModel.getAchId().toString());

        achievements.setHeading(achievementModel.getHeading().trim());
        achievements.setDescription(achievementModel.getDesc());

        return achievements;
    }
}
