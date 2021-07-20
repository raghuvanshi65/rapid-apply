package com.example.rapidapply.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@JsonSerialize
@JsonDeserialize(as = ImmutableUser.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Value.Immutable
public interface User {

    @Nullable
    UUID getId();

    @Nonnull
    String getEmail();

    @Nonnull
    String getFullname();

    @Nonnull
    String getPhone();

    @Nullable
    Address getAddress();

    @Nullable
    List<PublicProfile> getPublicProfileList();
}
