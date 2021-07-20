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
@JsonDeserialize(as = ImmutableAddress.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Value.Immutable
public interface Address {

    @Nonnull
    UUID getUserId();

    @Nullable
    UUID getAddressId();

    @Nonnull
    String getAddressLine();

    @Nonnull
    String getCity();

    @Nonnull
    String getState();

    @Nonnull
    String getCountry();
}
