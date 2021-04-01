package pl.allegrotech.weatherapp.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.allegrotech.weatherapp.domain.Weather;
import pl.allegrotech.weatherapp.domain.WeatherService;
import pl.allegrotech.weatherapp.domain.WeatherDto;

@RestController
@RequestMapping(path = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
class WeatherController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    private final WeatherService weatherService;

    WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    WeatherDto getWeather(@RequestParam Double latitude, @RequestParam Double longitude) {
        logger.info("Getting weather for latitude = {} and longitude = {}", latitude, longitude);
        return weatherService.getWeatherByLocation(new Weather.Location(latitude, longitude)).toDto();
    }

}