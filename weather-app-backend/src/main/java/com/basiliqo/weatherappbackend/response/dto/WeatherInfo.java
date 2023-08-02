package com.basiliqo.weatherappbackend.response.dto;

public record WeatherInfo(long id,
                          String main,
                          String description) {
}
