##Zadanie 1

Twoim zadaniem jest dodanie nowego endpointu, pozwalającego na zapisywanie danych pogodowych dla danej lokalizacji.
Dane powinny być przechowywane w repozytorium in-memory oraz możliwe do pobrania za pomocą istniejącego endpointu typu GET.

Nowy endpoint powinien wyglądać następująco:

* metoda HTTP: POST
* ścieżka: ```/weather```
* body requestu:
    ```
    {
        "location": {
            "latitude": ...
            "longitude": ...
        }
        "temperature": ...
    }
    ```
* format response'u:
  * status: 201 Created
  * w body response'u powinny znajdować się zapisane dane pogodowe
  * dodatkowo chcemy zwracać nagłówek ```Location``` wskazujący na ścieżkę dodanego zasobu, tzn. ```/weather?latitude=...&longitude=...```
  
###Kroki do wykonania
* dopisz implementację endpointu w klasie ```WeatherController```, w celu dodania nagłówka ```Location``` w odpowiedzi użyj parametru ```uriComponentsBuilder```
* dopisz test integracyjny w klasie ```WeatherControllerIntegrationTest``` sprawdzający ścieżkę pozytywną
* użyj metody ```postForEntity``` z klasy ```TestRestTemplate```, możesz wzorować się na pozostałych testach
