package pl.allegrotech.weatherapp.infrastructure.openweathermap;

import pl.allegrotech.weatherapp.domain.Location;
import pl.allegrotech.weatherapp.domain.WeatherForecast;
import pl.allegrotech.weatherapp.domain.WeatherForecastProvider;
import pl.allegrotech.weatherapp.infrastructure.openweathermap.client.OpenWeatherMapClient;

class OpenWeatherMapForecastProvider implements WeatherForecastProvider {

    private final OpenWeatherMapClient openWeatherMapClient;

    OpenWeatherMapForecastProvider(OpenWeatherMapClient openWeatherMapClient) {
        this.openWeatherMapClient = openWeatherMapClient;
    }

    @Override
    public WeatherForecast getWeatherForecastByLocation(Location location) {
        return null; // TODO Zadanie 2
    }

}
