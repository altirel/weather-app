package com.basiliqo.weatherappbackend.response.dto;

import com.basiliqo.weatherappbackend.response.converter.UnixTimestampToLocalDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

public record SystemInfo(long id,
                         @JsonAlias("country") @JsonGetter("country") String countryCode,
                         @JsonAlias("sunrise") @JsonDeserialize(converter = UnixTimestampToLocalDateTimeConverter.class) LocalDateTime sunrise,
                         @JsonAlias("sunset") @JsonDeserialize(converter = UnixTimestampToLocalDateTimeConverter.class) LocalDateTime sunset) {


}
