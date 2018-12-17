package com.example.bibhujaitly.localweatherapp.model.network;

import com.example.bibhujaitly.localweatherapp.model.pojo.WeatherApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

  @GET("forecast.json")
  Observable<WeatherApiResponse> getWeatherData(@Query("key") String key, @Query("q") String city,
      @Query("days") int days);
}
