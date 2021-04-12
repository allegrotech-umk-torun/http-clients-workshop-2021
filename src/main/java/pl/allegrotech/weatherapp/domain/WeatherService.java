package pl.allegrotech.weatherapp.domain;

public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherForecastProvider weatherForecastProvider;

    public WeatherService(WeatherRepository weatherRepository, WeatherForecastProvider weatherForecastProvider) {
        this.weatherRepository = weatherRepository;
        this.weatherForecastProvider = weatherForecastProvider;
    }

    public Weather getWeatherByLocation(Location location) {
        return weatherRepository.getWeatherByLocation(location)
                .orElseThrow(() -> new WeatherNotFoundException(location));
    }

    public WeatherForecast getWeatherForecastByLocation(Location location) {
        return weatherForecastProvider.getWeatherForecastByLocation(location);
    }

}
