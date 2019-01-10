package com.example.bibhujaitly.localweatherapp.model.network;

import com.example.bibhujaitly.localweatherapp.model.pojo.WeatherApiResponse;
import io.reactivex.Single;
import retrofit2.Retrofit;

public class APIHelper {

  Retrofit retrofit;

  public APIHelper(Retrofit retrofit) {
    this.retrofit = retrofit;
  }

  public Single<WeatherApiResponse> getWeatherApi(String city, int days) {
    return retrofit.create(APIService.class)
        .getWeatherData(NetworkUtil.API_KEY, city, days)
        .cache();
  }
}
