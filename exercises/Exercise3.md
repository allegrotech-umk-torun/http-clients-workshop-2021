##Zadanie 3

Zadanie składa się z dwóch części:
1. W klasie ```WebExceptionHandler``` dodaj obsługę różnego rodzaju błędów, które mogą pojawić się podczas odpytywania zewnętrznej usługi.
Weź pod uwagę wyjątki: ```HttpClientException```, ```HttpServerException```, ```ResourceAccessException```.
Naszym celem jest, żeby endpoint ```/forecast/weather``` zwrócił:
   * dla błędów po stronie serwera (5xx) -> HttpStatus.INTERNAL_SERVER_ERROR
   * dla błędów po stronie klienta (4xx) -> HttpStatus.BAD_REQUEST
   * dla błędów związanych z timeoutami -> HttpStatus.REQUEST_TIMEOUT
2. Skonfiguruj timeouty dla klienta HTTP znajdującego się w klasie ```OpenWeatherMapClient```. 
Możesz w tym celu dodać beana ```HttpComponentsClientHttpRequestFactory``` i użyć go przy tworzeniu RestTemplate.
Konfigurację dodaj w klasie ```OpenWeatherMapConfig```.
   
####Pytania dodatkowe
* jak wywołać błąd po stronie klienta?
* jak wywołać błąd związany z timeoutem?
* jak wywołać błąd po stronie serwera?
* jak testować automatycznie różne scenariusze związane z komunikacją między usługami?