package com.example.rapidapply.commons;

import com.example.rapidapply.entity.Skills;
import com.example.rapidapply.helpers.PowerStringTokenizer;
import com.example.rapidapply.models.ImmutableSkills;

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

        skills.setSkillSubset(PowerStringTokenizer.listToString(skillsModel.getSkillSubset()));
        skills.setSkillType(skillsModel.getSkillType());

        return skills;
    }

    public static com.example.rapidapply.models.Skills entityToModel(Skills skillsEntity){
        return ImmutableSkills.builder().skillId(UUID.fromString(skillsEntity.getSkillId()))
                .skillType(skillsEntity.getSkillType()).skillSubset(PowerStringTokenizer.stringToList(skillsEntity.getSkillSubset()))
                .build();
    }
}
