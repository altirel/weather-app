package com.basiliqo.weatherappbackend.response;

import com.basiliqo.weatherappbackend.response.converter.UnixTimestampToLocalDateTimeConverter;
import com.basiliqo.weatherappbackend.response.dto.Coordinates;
import com.basiliqo.weatherappbackend.response.dto.MainWeatherInfo;
import com.basiliqo.weatherappbackend.response.dto.SystemInfo;
import com.basiliqo.weatherappbackend.response.dto.WeatherInfo;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

public record OpenWeatherCurrentResponse(@JsonAlias("coord") Coordinates coord,
                                         @JsonAlias("weather") List<WeatherInfo> weather,
                                         @JsonAlias("main") @JsonGetter("main") MainWeatherInfo mainWeatherInfo,
                                         @JsonAlias("sys") SystemInfo sys,
                                         @JsonAlias("dt") @JsonGetter("dt") @JsonDeserialize(converter = UnixTimestampToLocalDateTimeConverter.class) LocalDateTime updatedAt,
                                         @JsonAlias("timezone") long timezone,
                                         @JsonAlias("id") long id,
                                         @JsonAlias("name") @JsonGetter("name") String locationName) {
}
