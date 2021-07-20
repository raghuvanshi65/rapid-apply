package com.example.rapidapply.commons;

import com.example.rapidapply.entity.Education;
import com.example.rapidapply.helpers.Grading;

import java.util.Locale;
import java.util.UUID;

public class EducationMapper {
    public static Education modelToEntity(com.example.rapidapply.models.Education educationModel) {
        Education educationEntity = new Education();
        if (educationEntity.getEducationId() == null)
            educationEntity.setEducationId(UUID.randomUUID().toString());
        else
            educationEntity.setEducationId(educationModel.getEducationId().toString());

        educationEntity.setAcademicLevel(educationModel.getAcademicLevel().trim());
        educationEntity.setInstitueName(educationModel.getInstituteName().trim());
        educationEntity.setGrading(Grading.getEnum(educationModel.getGrading().trim().toUpperCase(Locale.ROOT)).toString());
        educationEntity.setMarksGrade(educationModel.getMarksGrade());
        educationEntity.setStartingYear(educationModel.getStartingYear());
        educationEntity.setEndingYear(educationModel.getEndingYear());

        return educationEntity;
    }
}
