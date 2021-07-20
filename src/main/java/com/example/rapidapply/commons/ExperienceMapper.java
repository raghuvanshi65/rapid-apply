package com.example.rapidapply.commons;

import com.example.rapidapply.entity.Experience;
import com.example.rapidapply.models.ImmutableExperience;

import java.sql.Date;
import java.util.UUID;

public class ExperienceMapper {
    public static final Experience modelToEntity(com.example.rapidapply.models.Experience experienceModel) {
        Experience experienceEntity = new Experience();
        if (experienceModel.getExpId() == null)
            experienceEntity.setExperienceId(UUID.randomUUID().toString());
        else
            experienceEntity.setExperienceId(experienceModel.getExpId().toString());

        experienceEntity.setOrgName(experienceModel.getOrgName());
        experienceEntity.setWorkProfile(experienceModel.getWorkProfile());
        experienceEntity.setDescription(experienceModel.getDescription());
        if (experienceModel.getCertificateLink() != null)
            experienceEntity.setCertificateLink(experienceModel.getCertificateLink());

        if (experienceModel.getProductLink() != null)
            experienceEntity.setProductLink(experienceModel.getProductLink());

        experienceEntity.setStartDate(Date.valueOf(experienceModel.getStartDate()));
        experienceEntity.setCurrent(experienceModel.getCurrent()==null || experienceModel.getCurrent()>0   ? 'Y' : 'N');
        experienceEntity.setEndDate(experienceModel.getEndDate()!=null ? Date.valueOf(experienceModel.getEndDate()) : null);

        return experienceEntity;
    }

    public static com.example.rapidapply.models.Experience entityToModel(Experience experience){
        return ImmutableExperience.builder().expId(UUID.fromString(experience.getExperienceId()))
                .orgName(experience.getOrgName()).workProfile(experience.getWorkProfile())
                .description(experience.getDescription()).current(experience.getCurrent()=='Y'?1:0)
                .startDate(experience.getStartDate().toString())
                .certificateLink(experience.getCertificateLink()==null?null:experience.getCertificateLink())
                .productLink(experience.getProductLink()!=null? experience.getProductLink() : null)
                .endDate(experience.getEndDate().toString()).build();
    }
}
