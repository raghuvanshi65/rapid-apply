package com.example.rapidapply.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.UUID;

@JsonSerialize
@JsonDeserialize(as = ImmutableAchievements.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Value.Immutable
public interface Achievements {

    @Nullable
    UUID getAchId();

    @NotNull
    String getHeading();

    @Nullable
    String getDesc();
}
