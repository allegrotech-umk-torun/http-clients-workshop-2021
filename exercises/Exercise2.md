##Zadanie 2

Twoim zadaniem jest dokończenie implementacji endpointu, pozwalającego na zwrócenie prognozy pogody na kolejne 7 dni dla podanej lokalizacji.
Endpoint ten znajduje się w klasie ```WeatherController``` i ma następującą postać:
```
GET /weather/forecast?latitude=...&longitude=...
```

Do pobrania prognozy pogody możesz użyć zewnętrznego serwisu (https://openweathermap.org).
Poniżej znajduje się przykładowe zapytanie o dzienną prognozę pogody na kolejne 7 dni dla podanej lokalizacji:
```
GET https://api.openweathermap.org/data/2.5/onecall?lat=53.0138&lon=18.5984&exclude=current,hourly,minutely,alerts&units=metric&appid=f8808a0fe2a10e44874330a3e69e1b34
```

Parametry zapytania:
* lat i lon - współrzędne lokalizacji, dla której pobieramy prognozę pogody
* exclude - fragmenty odpowiedzi, które nas nie interesują, w tym przykładzie zostaną zwrócone tylko dane dzienne
* units - rodzaj jednostek używanych do reprezentowania wartości
* appid - apiKey powiązany z użytkownikiem

Format odpowiedzi:

```
{
    ...
    "daily": [
        "dt": 1618135200, // data jako "Unix timeestamp"
        "temp": {
            "day": 15.7,
            ...
        },
        ...
    ],
    ...
}
```

###Kroki do wykonania:
* implementację odpytania zewnętrznego serwisu o prognozę pogody dodaj w klasie ```OpenWeatherMapClient```
* w pliku ```apiKeys.txt``` znajdują się testowe apiKey, które możesz użyć w pliku ```application.yml```
* uzupełnij model odpowiedzi w klasie ```OpenWeatherMapResponse```, z pobranej odpowiedzi interesują nas tylko dwie informacje: data (pole ```dt```) i dzienna temperatura (pole ```temp.day```)
* w klasie ```OpenWeatherMapForecastProvider``` przemapuj pobraną odpowiedź na model domenowy, dla pola ```dt``` możesz skorzystać z metody ```Instant.ofEpochSecond()```
