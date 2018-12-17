package com.example.bibhujaitly.localweatherapp.model.network;

import com.example.bibhujaitly.localweatherapp.model.pojo.WeatherApiResponse;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIHelper {

  Retrofit retrofit;

  public Retrofit getRetrofitInstance() {
    if (retrofit == null) {
      retrofit = new Retrofit.Builder().baseUrl(NetworkUtil.BASE_URL)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient())
          .build();
    }
    return retrofit;
  }

  public Observable<WeatherApiResponse> getWeatherApi(String city, int days) {
    return getRetrofitInstance().create(APIService.class)
        .getWeatherData(NetworkUtil.API_KEY, city, days)
        .cache();
  }
}
