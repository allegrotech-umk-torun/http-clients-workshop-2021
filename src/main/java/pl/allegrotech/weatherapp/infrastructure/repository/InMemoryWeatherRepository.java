package pl.allegrotech.weatherapp.infrastructure.repository;

import pl.allegrotech.weatherapp.domain.Location;
import pl.allegrotech.weatherapp.domain.Weather;
import pl.allegrotech.weatherapp.domain.WeatherRepository;

import java.util.*;

public class InMemoryWeatherRepository implements WeatherRepository {

    private final Map<Location, Weather> storage = new HashMap<>();

    @Override
    public void save(Weather weather) {
        storage.put(weather.getLocation(), weather);
    }

    @Override
    public Optional<Weather> getWeatherByLocation(Location location) {
        return Optional.ofNullable(storage.get(location));
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }

    @Override
    public Optional<List<Weather>> getAll() {
        return Optional.of(new ArrayList<>(storage.values()));
    }

}
