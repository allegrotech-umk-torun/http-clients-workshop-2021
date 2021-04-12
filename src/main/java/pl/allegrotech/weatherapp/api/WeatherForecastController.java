package pl.allegrotech.weatherapp.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.allegrotech.weatherapp.domain.Location;
import pl.allegrotech.weatherapp.domain.WeatherForecast;
import pl.allegrotech.weatherapp.domain.WeatherService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
class WeatherForecastController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherForecastController.class);

    private final WeatherService weatherService;

    WeatherForecastController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(path = "/forecast/weather", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<WeatherForecastApiResponse> getWeatherForecast(
            @RequestParam(name = "latitude") double latitude,
            @RequestParam(name = "longitude") double longitude
    ) {
        logger.info("Getting weather forecast for latitude = {} and longitude = {}", latitude, longitude);
        WeatherForecast weatherForecast = weatherService.getWeatherForecastByLocation(new Location(latitude, longitude));
        return ResponseEntity.ok(weatherForecast.toApiResponse());
    }

}
