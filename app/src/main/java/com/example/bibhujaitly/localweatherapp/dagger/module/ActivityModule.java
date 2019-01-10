package com.example.bibhujaitly.localweatherapp.dagger.module;

import com.example.bibhujaitly.localweatherapp.model.network.APIHelper;
import com.example.bibhujaitly.localweatherapp.model.network.NetworkUtil;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ActivityModule {

  @Provides
  @Singleton
  public APIHelper getApiHelper(Retrofit retrofit) {
    return new APIHelper(retrofit);
  }

  @Provides
  public Retrofit getRetrofitInstance(OkHttpClient client, GsonConverterFactory converterFactory,
      RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
    return new Retrofit.Builder().baseUrl(NetworkUtil.BASE_URL)
        .addCallAdapterFactory(rxJava2CallAdapterFactory)
        .addConverterFactory(converterFactory)
        .client(client)
        .build();
  }

  @Provides
  public GsonConverterFactory getGsonConverterFactory(){
    return GsonConverterFactory.create();
  }

  @Provides
  public RxJava2CallAdapterFactory getRxAdaptorFactory(){
    return RxJava2CallAdapterFactory.create();
  }

  @Provides
  public OkHttpClient getHttpClient(OkHttpClient.Builder builder){
    return builder.build();
  }

  @Provides
  public OkHttpClient.Builder getHttpClientBuilder(){
    return new OkHttpClient.Builder();
  }
}