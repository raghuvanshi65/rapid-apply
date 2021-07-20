package com.example.rapidapply.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

@JsonSerialize
@JsonDeserialize(as = ImmutableExperience.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Value.Immutable
public interface Experience {

    @Nullable
    UUID getExpId();

    @Nonnull
    String getOrgName();

    @Nonnull
    String getDescription();

    @Nonnull
    String getWorkProfile();

    @Nullable
    String getCertificateLink();

    @Nullable
    String getProductLink();

    @Nonnull
    String getStartDate();

    @Nullable
    Integer getCurrent();

    @Nullable
    String getEndDate();
}
