package com.basiliqo.weatherappbackend.openweather;

import jakarta.annotation.Nonnull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.net.URI;

public class OpenWeatherHttpRequest implements HttpRequest {

    private final URI customUri;
    private final HttpRequest baseHttpRequest;

    private OpenWeatherHttpRequest(HttpRequest baseHttpRequest, URI customUri) {
        this.baseHttpRequest = baseHttpRequest;
        this.customUri = customUri;
    }

    public static OpenWeatherHttpRequest create(HttpRequest baseHttpRequest, URI customUri) {
        return new OpenWeatherHttpRequest(baseHttpRequest, customUri);
    }

    @Nonnull
    @Override
    public HttpMethod getMethod() {
        return baseHttpRequest.getMethod();
    }

    @Nonnull
    @Override
    public URI getURI() {
        return customUri;
    }

    @Nonnull
    @Override
    public HttpHeaders getHeaders() {
        return baseHttpRequest.getHeaders();
    }
}
