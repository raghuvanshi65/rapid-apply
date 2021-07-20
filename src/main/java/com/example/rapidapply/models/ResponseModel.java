package com.example.rapidapply.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(as = ImmutableResponseModel.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
@Value.Immutable
public interface ResponseModel<T> {

    @Nonnull
    Boolean getAccepted();

    @Nonnull
    String getMessage();

    @Nullable
    T getBody();
}
