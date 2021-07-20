package com.example.rapidapply.commons;

import com.example.rapidapply.entity.Achievements;
import com.example.rapidapply.models.ImmutableAchievements;

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

    public static com.example.rapidapply.models.Achievements entityToModel(Achievements achievements){
        return ImmutableAchievements.builder().achId(UUID.fromString(achievements.getAchId()))
                .heading(achievements.getHeading()).desc(achievements.getDescription()).build();
    }
}
