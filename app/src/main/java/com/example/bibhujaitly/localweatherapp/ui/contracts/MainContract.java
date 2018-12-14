package com.example.bibhujaitly.localweatherapp.ui.contracts;

import com.example.bibhujaitly.localweatherapp.model.pojo.WeatherApiResponse;

public interface MainContract {

    interface MainMvpView {
        void showProgress();

        void showError();

        void hideProgress();

        void showFetchedData(WeatherApiResponse response);
    }

    interface Presenter {

        void requestWeatherData(String city, int days);

    }

    interface NetworkApiHelper {
    }

}
