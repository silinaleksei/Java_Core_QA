package lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.Objects;

public class AccuWeather {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("forecasts/v1/daily/5day/295212") // 5 дней
                //.addPathSegments("forecasts/v1/daily/1day/295212") // 1 день
                .addQueryParameter("apikey", "XcBpOGA0G2Lnwrhh7KCJyPnji0aml6Kj")
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("details", "false")
                .addQueryParameter("metric", "true")
                .build();
        System.out.println(url); // http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=XcBpOGA0G2Lnwrhh7KCJyPnji0aml6Kj&language=ru-ru&details=false&metric=true
        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();
        String jsonResponse = Objects.requireNonNull(client.newCall(request).execute().body()).string();
        System.out.println(jsonResponse);
    }
}
