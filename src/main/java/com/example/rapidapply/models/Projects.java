package com.example.rapidapply.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;
import org.immutables.value.Value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@JsonSerialize
@JsonDeserialize(as = ImmutableProjects.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Value.Immutable
public interface Projects {

    @Nullable
    UUID getProjectId();

    @NotNull
    String getProjectName();

    @Nullable
    List<String> getLanguages();

    @Nullable
    List<String> getTechStack();

    @Nonnull
    String getDescription();

    @Nonnull
    String getStartingDate();

    @Nonnull
    Integer getWIP();

    @Nullable
    String getEndingDate();

    @Nullable
    String getProjectLink();
}
