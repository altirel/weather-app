package com.basiliqo.weatherappbackend.weather;

import com.basiliqo.weatherappbackend.openweather.OpenWeatherRestFacade;
import com.basiliqo.weatherappbackend.response.OpenWeatherCurrentResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final OpenWeatherRestFacade openWeatherRestApi;

    public WeatherController(RestTemplate restTemplate) {
        this.openWeatherRestApi = OpenWeatherRestFacade.create(restTemplate);
    }

    @Cacheable("weather")
    @GetMapping("/current/location")
    public ResponseEntity<OpenWeatherCurrentResponse> getByCoordinates(@RequestParam(name = "lon") double lon,
                                                                       @RequestParam(name = "lat") double lat,
                                                                       @RequestParam(name = "units", required = false) String units,
                                                                       @RequestParam(name = "lang", required = false) String lang) {
        OpenWeatherCurrentResponse body = openWeatherRestApi
                .fetchCurrentByCoordinates(lon, lat, lang, units)
                .getBody();
        return ResponseEntity.ok(body);
    }

    @Cacheable("weather")
    @GetMapping("/current/city")
    public ResponseEntity<OpenWeatherCurrentResponse> getByCity(@RequestParam(name = "q") String city,
                                                                @RequestParam(name = "units", required = false) String units,
                                                                @RequestParam(name = "lang", required = false) String lang) {
        OpenWeatherCurrentResponse body = openWeatherRestApi
                .fetchCurrentByCity(city, lang, units)
                .getBody();
        return ResponseEntity.ok(body);
    }
}
