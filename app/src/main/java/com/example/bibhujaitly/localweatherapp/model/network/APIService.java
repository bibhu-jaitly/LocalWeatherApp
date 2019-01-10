package com.example.bibhujaitly.localweatherapp.model.network;

import com.example.bibhujaitly.localweatherapp.model.pojo.WeatherApiResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

  @GET("forecast.json")
  Single<WeatherApiResponse> getWeatherData(@Query("key") String key, @Query("q") String city,
      @Query("days") int days);
}
