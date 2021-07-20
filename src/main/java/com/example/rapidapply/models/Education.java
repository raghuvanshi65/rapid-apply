package com.example.rapidapply.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Year;
import java.util.UUID;

@JsonSerialize
@JsonDeserialize(as = ImmutableEducation.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Value.Immutable
public interface Education {

    @Nullable
    UUID getEducationId();

    @Nonnull
    String getInstituteName();

    @Nonnull
    String getAcademicLevel();

    @Nonnull
    String getGrading();

    @Nonnull
    String getMarksGrade();

    @Nonnull
    String getStartingYear();

    @Nonnull
    String getEndingYear();
}
