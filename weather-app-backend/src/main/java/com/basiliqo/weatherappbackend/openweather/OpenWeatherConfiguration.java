package com.basiliqo.weatherappbackend.openweather;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Getter
@Setter
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "openweather.api")
public class OpenWeatherConfiguration {

    private String key;

    private String uri;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .interceptors(OpenWeatherLoggingInterceptor.create(key))
                .rootUri(uri)
                .build();
    }
}
