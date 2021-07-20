package com.example.rapidapply.commons;

import com.example.rapidapply.entity.Skills;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class SkillsMapper {
    public static Skills modelToEntity(com.example.rapidapply.models.Skills skillsModel){
        Skills skills = new Skills();
        if (skills.getSkillId() == null)
            skills.setSkillId(UUID.randomUUID().toString());
        else
            skills.setSkillId(skillsModel.getSkillId().toString());

        skills.setSkillSubset(listToString(skillsModel.getSkillSubset()));
        skills.setSkillType(skillsModel.getSkillType());

        return skills;
    }

    public static String listToString(List<String> skillSubsetList){
        return skillSubsetList.stream().map(Objects::toString).collect(Collectors.joining(","));
    }

    public static List<String> stringToList(String skillSubset){
        return Arrays.asList(skillSubset.split(","));
    }
}
