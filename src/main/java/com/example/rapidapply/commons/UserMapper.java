package com.example.rapidapply.commons;

import com.example.rapidapply.entity.*;
import com.example.rapidapply.models.ImmutableUser;
import com.example.rapidapply.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserMapper {

    public static User userEntityToModel(com.example.rapidapply.entity.User userEntity) {
        List<PublicProfile> publicProfileList = userEntity.getPublicProfileList();
        List<com.example.rapidapply.models.PublicProfile> publicProfileList1 = new ArrayList<>();

        List<Education> educationList = userEntity.getEducationList();
        List<com.example.rapidapply.models.Education> educationList1 = new ArrayList<>();

        List<Skills> skillsList = userEntity.getSkillsList();
        List<com.example.rapidapply.models.Skills> skillsList1 = new ArrayList<>();

        List<Projects> projectsList = userEntity.getProjectsList();
        List<com.example.rapidapply.models.Projects> projectsList1 = new ArrayList<>();

        List<Experience> experienceList = userEntity.getExperienceList();
        List<com.example.rapidapply.models.Experience> experienceList1 = new ArrayList<>();

        List<Achievements> achievementsList = userEntity.getAchievementsList();
        List<com.example.rapidapply.models.Achievements> achievementsList1 = new ArrayList<>();

        if (publicProfileList != null && !publicProfileList.isEmpty())
            for (PublicProfile publicProfile : publicProfileList)
                publicProfileList1.add(PublicProfileMapper.entityToModel(publicProfile));

        if (projectsList != null && !projectsList.isEmpty())
            for (Projects projects : projectsList)
                projectsList1.add(ProjectsMapper.entityToModel(projects));

        if (educationList != null && !educationList.isEmpty())
            for (Education education : educationList)
                educationList1.add(EducationMapper.entityToModel(education));

        if (skillsList != null && !skillsList.isEmpty())
            for (Skills skills : skillsList)
                skillsList1.add(SkillsMapper.entityToModel(skills));

        if (experienceList != null && !experienceList.isEmpty())
            for (Experience experience : experienceList)
                experienceList1.add(ExperienceMapper.entityToModel(experience));

        if (achievementsList != null && !achievementsList.isEmpty())
            for (Achievements achievements : achievementsList)
                achievementsList1.add(AchievementMapper.entityToModel(achievements));

        return ImmutableUser.builder().id(UUID.fromString(userEntity.getUserId()))
                .email(userEntity.getEmail()).fullname(userEntity.getFullname())
                .phone(userEntity.getPhone()).address(AddressMapper.entityToModel(userEntity.getAddress()))
                .publicProfileList(publicProfileList1).educationList(educationList1)
                .skillsList(skillsList1).projectsList(projectsList1)
                .experienceList(experienceList1).achievementsList(achievementsList1).build();
    }
}
