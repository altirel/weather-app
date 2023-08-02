package com.basiliqo.weatherappbackend.response.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;

public record MainWeatherInfo(double temp,
                              @JsonAlias("feels_like") @JsonGetter("feels_like") double feelsLike,
                              @JsonAlias("temp_min") @JsonGetter("temp_min") double tempMin,
                              @JsonAlias("temp_max") @JsonGetter("temp_max") double tempMax,
                              int pressure,
                              int humidity,
                              @JsonAlias("sea_level") @JsonGetter("sea_level") int seaLevel,
                              @JsonAlias("grnd_level") @JsonGetter("grnd_level") int groundLevel) {
}
