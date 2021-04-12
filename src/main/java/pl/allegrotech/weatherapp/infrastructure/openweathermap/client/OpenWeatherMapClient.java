package pl.allegrotech.weatherapp.infrastructure.openweathermap.client;

import org.springframework.web.client.RestTemplate;
import pl.allegrotech.weatherapp.domain.Location;

public class OpenWeatherMapClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final String apiKey;

    public OpenWeatherMapClient(RestTemplate restTemplate, String baseUrl, String apiKey) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    public OpenWeatherMapResponse getWeatherForecast(Location location) {
        // TODO Zadanie 2
        String url = prepareUrl(location.getLatitude(), location.getLongitude());
        return restTemplate.getForEntity(url, OpenWeatherMapResponse.class).getBody();
    }

    private String prepareUrl(double latitude, double longitude) {
        return String.format(
                "%s?lat=%s&lon=%s&appid=%s&exclude=current,hourly,minutely,alerts&units=metric",
                baseUrl,
                latitude,
                longitude,
                apiKey
        );
    }

}