package com.example.bibhujaitly.localweatherapp.ui.contracts;

import com.example.bibhujaitly.localweatherapp.model.pojo.WeatherApiResponse;
import com.example.bibhujaitly.localweatherapp.ui.BasePresenter;
import com.example.bibhujaitly.localweatherapp.ui.BaseView;
import io.reactivex.disposables.CompositeDisposable;

public interface MainContract {

  interface MainMvpView extends BaseView<Presenter> {
    void showProgress();

    void showError();

    void hideProgress();

    void showFetchedData(WeatherApiResponse response);

    void requestPermission();

    void fetchData();
  }

  interface Presenter extends BasePresenter<MainMvpView> {

    void requestWeatherData(String city, int days);

    void getCompositeDisposable(CompositeDisposable disposable);
  }
}
