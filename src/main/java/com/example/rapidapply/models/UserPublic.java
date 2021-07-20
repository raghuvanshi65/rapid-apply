package com.example.rapidapply.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;
import org.immutables.value.Value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

@JsonSerialize
@JsonDeserialize(as = ImmutableUserPublic.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Value.Immutable
public interface UserPublic {

    @NotNull
    UUID getId();

    @Nonnull
    String getEmail();

    @Nonnull
    String getFullname();

    @Nonnull
    String getPhone();
}
