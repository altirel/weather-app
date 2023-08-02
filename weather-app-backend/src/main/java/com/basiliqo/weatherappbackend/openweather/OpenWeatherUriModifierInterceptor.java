package com.basiliqo.weatherappbackend.openweather;

import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@Slf4j
public class OpenWeatherUriModifierInterceptor implements ClientHttpRequestInterceptor {

    private final static String APPID_PATH_VARIABLE = "appid";

    private final String appid;

    private OpenWeatherUriModifierInterceptor(String appid) {
        this.appid = appid;
    }

    public static OpenWeatherUriModifierInterceptor create(String appId) {
        return new OpenWeatherUriModifierInterceptor(appId);
    }

    @Nonnull
    @Override
    public ClientHttpResponse intercept(@Nonnull HttpRequest request,
                                        @Nonnull byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        URI modifiedUri = UriComponentsBuilder.fromHttpRequest(request)
                .queryParam(APPID_PATH_VARIABLE, appid)
                .build()
                .toUri();
        request = OpenWeatherHttpRequest.create(request, modifiedUri);

        log.debug("Headers: {}", request.getHeaders());
        log.debug("Request Method: {}", request.getMethod());
        log.debug("Request URI: {}", request.getURI());
        log.debug("-------------------------------------------------------------");

        return execution.execute(request, body);
    }
}
