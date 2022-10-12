package lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.Objects;

public class YandexWeather {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.weather.yandex.ru")
                .addPathSegments("v2/informers")
                .addQueryParameter("lat", "59.939")
                .addQueryParameter("lon", "30.315")
                .addQueryParameter("lang", "ru_RU")
                .build();
        System.out.println(url); // https://api.weather.yandex.ru/v2/informers?lat=59.939&lon=30.315&lang=ru_RU
        Request request = new Request.Builder()
                .addHeader("X-Yandex-API-Key", "402621ae-5a67-4692-b560-d7369328a9b1")
                .url(url)
                .build();
        String jsonResponse = Objects.requireNonNull(client.newCall(request).execute().body()).string();
        System.out.println(jsonResponse);
    }
}
