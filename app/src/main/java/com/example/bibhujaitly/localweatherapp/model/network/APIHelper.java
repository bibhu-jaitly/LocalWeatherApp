package com.example.bibhujaitly.localweatherapp.model.network;

import com.example.bibhujaitly.localweatherapp.model.pojo.WeatherApiResponse;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIHelper {

  Retrofit retrofit;

  public Retrofit getRerofitInstance() {
    if (retrofit == null) {
      retrofit = new Retrofit.Builder().baseUrl("test")
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient())
          .build();
    }
    return retrofit;
  }

  public Observable<WeatherApiResponse> getWeatherApi(String city, int days) {
        return getRerofitInstance().create(APIService.class).getWeatherData(city, days).cache();
  }
}
