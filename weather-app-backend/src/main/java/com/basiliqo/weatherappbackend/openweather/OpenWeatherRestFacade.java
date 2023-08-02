package com.basiliqo.weatherappbackend.openweather;

import com.basiliqo.weatherappbackend.response.OpenWeatherCurrentResponse;
import jakarta.annotation.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OpenWeatherRestFacade {

    private final static String DEFAULT_LANG = "en";

    private final static String DEFAULT_UNITS = "metric";

    private final RestTemplate restTemplate;

    private OpenWeatherRestFacade(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static OpenWeatherRestFacade create(RestTemplate restTemplate) {
        return new OpenWeatherRestFacade(restTemplate);
    }

    /**
     * Generates uri path depending on input parameters (required: geographic coordinates defined by longitude and
     * latitude, and optional: language and units) and calls an Open Weather API
     *
     * @param lon longitude
     * @param lat latitude
     * @param lang language code (default - en | english)
     * @param units temperature units system (default - metric | celsius degrees)
     * @return detailed information about weather in specific geographic coordinates
     */
    public ResponseEntity<OpenWeatherCurrentResponse> fetchCurrentByCoordinates(double lon,
                                                                                double lat,
                                                                                @Nullable String lang,
                                                                                @Nullable String units) {
        String path = String.format("/weather?lon=%s&lat=%s&lang=%s&units=%s", lon, lat,
                lang != null ? lang : DEFAULT_LANG,
                units != null ? units : DEFAULT_UNITS);
        return restTemplate.getForEntity(path, OpenWeatherCurrentResponse.class);
    }

    /**
     * Generates uri path depending on input parameters (required: city name, and optional: language and units) and
     * calls an Open Weather API
     *
     * @param city city name
     * @param lang language code (default - en | english)
     * @param units temperature units system (default - metric | celsius degrees)
     * @return detailed information about weather in provided city
     */
    public ResponseEntity<OpenWeatherCurrentResponse> fetchCurrentByCity(String city,
                                                                         @Nullable String lang,
                                                                         @Nullable String units) {
        String path = String.format("/weather?q=%s&lang=%s&units=%s", city,
                lang != null ? lang : DEFAULT_LANG,
                units != null ? units : DEFAULT_UNITS);
        return restTemplate.getForEntity(path, OpenWeatherCurrentResponse.class);
    }
}
