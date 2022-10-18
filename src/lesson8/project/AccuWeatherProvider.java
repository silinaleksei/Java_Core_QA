package lesson8.project;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson8.project.entity.WeatherResponse;
import lesson8.project.fivedaysweather.FiveDaysWeather;
import lesson8.project.entity.WeatherData;
import lesson8.project.enums.Periods;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    DatabaseRepository databaseRepository = new DatabaseRepositorySQLiteImpl();


    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();
            //System.out.println(url); // http://dataservice.accuweather.com/currentconditions/v1/294021?apikey=0d1tNZJPfzzT3qGokM18FGGxAUpt7hpj
            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            //System.out.println(response.body().string());
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            WeatherResponse[] weatherResponse = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), WeatherResponse[].class);
            System.out.println("The current weather in "
                    + ApplicationGlobalState.getInstance().getSelectedCity().toUpperCase()
                    /*+ weatherResponse[0].getMobileLink().substring(33, 39).toUpperCase()*/
                    + " on " + weatherResponse[0].getLocalObservationDateTime().substring(0, 10)
                    + " is " + weatherResponse[0].getWeatherText()
                    + ", temperature = "
                    + weatherResponse[0].getTemperature().getMetric().getValue() + "\u00B0C"); // The current weather in MOSCOW is Cloudy, temperature = 4.6°C

            WeatherData weatherData = new WeatherData();
            weatherData.setCity(ApplicationGlobalState.getInstance().getSelectedCity().toUpperCase());
            weatherData.setLocalDate(weatherResponse[0].getLocalObservationDateTime().substring(0, 10));
            weatherData.setText(weatherResponse[0].getWeatherText());
            weatherData.setTemperature(weatherResponse[0].getTemperature().getMetric().getValue());


            try {
                databaseRepository.saveWeatherData(weatherData);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


//            System.out.println("Data from class WeatherData: "
//                    + "1. City: " + weatherData.getCity()
//                    + ", 2. LocalDate: " + weatherData.getLocalDate()
//                    + ", 3. Text: " + weatherData.getText()
//                    + ", 4. Temperature: " + weatherData.getTemperature());


        } else if (periods.equals(Periods.FIVE_DAYS)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegments("daily/5day")
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    //.addQueryParameter("language", "ru-ru") // uncomment for Russian
                    .addQueryParameter("details", "false")
                    .addQueryParameter("metric", "true")
                    .build();
            //System.out.println(url); // http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=XcBpOGA0G2Lnwrhh7KCJyPnji0aml6Kj&language=ru&details=true&metric=true"
            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            FiveDaysWeather fiveDaysWeather = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), FiveDaysWeather.class);
            for (int i = 0; i <= 4; i++) {
                System.out.println("Weather in city "
                        + ApplicationGlobalState.getInstance().getSelectedCity().toUpperCase()
                        + " on the date: " + fiveDaysWeather.getDailyForecasts().get(i).getDate().substring(0, 10)
                        + " expected in the afternoon: "
                        + fiveDaysWeather.getDailyForecasts().get(i).getDay().getIconPhrase()
                        + ", at night: " + fiveDaysWeather.getDailyForecasts().get(i).getNight().getIconPhrase()
                        + ", temperature: min = "
                        + fiveDaysWeather.getDailyForecasts().get(i).getTemperature().getMinimum().getValue()
                        + "\u00B0C, max = "
                        + (fiveDaysWeather.getDailyForecasts().get(i).getTemperature().getMaximum().getValue())
                        + "\u00B0C");

                WeatherData weatherData = new WeatherData();
                weatherData.setCity(ApplicationGlobalState.getInstance().getSelectedCity().toUpperCase());
                weatherData.setLocalDate(fiveDaysWeather.getDailyForecasts().get(i).getDate().substring(0, 10));
                weatherData.setText("in the afternoon: "
                        + fiveDaysWeather.getDailyForecasts().get(i).getDay().getIconPhrase()
                        + ", at night: " + fiveDaysWeather.getDailyForecasts().get(i).getNight().getIconPhrase());
                weatherData.setTemperature((fiveDaysWeather.getDailyForecasts().get(i).getTemperature().getMinimum().getValue()
                        + (fiveDaysWeather.getDailyForecasts().get(i).getTemperature().getMaximum().getValue()))/2);


                try {
                    databaseRepository.saveWeatherData(weatherData);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (periods.equals(Periods.CUSTOM)) {
            try {
                databaseRepository.getAllSavedData();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("It is impossible to read information about the city." +
                    "Server response code = " + response.code() + " response body = " + Objects.requireNonNull(response.body()).string());
        }
        String jsonResponse = Objects.requireNonNull(response.body()).string();
        System.out.println("Looking for a city: " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Found city " + cityName + " in country " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }
}
