package com.example.bibhujaitly.localweatherapp.ui.presenter;

import android.util.Log;
import com.example.bibhujaitly.localweatherapp.model.network.APIHelper;
import com.example.bibhujaitly.localweatherapp.ui.contracts.MainContract;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {

  private MainContract.MainMvpView mainMvpView;
  private APIHelper apiHelper;

  private CompositeDisposable compositeDisposable;

  public MainPresenter(MainContract.MainMvpView view, CompositeDisposable compositeDisposable) {
    mainMvpView = view;
    apiHelper = new APIHelper();
    this.compositeDisposable = compositeDisposable;
  }

  @Override
  public void requestWeatherData(String city, int days) {
    mainMvpView.showProgress();
    compositeDisposable.add(apiHelper.getWeatherApi(city, days)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(weatherApiResponse -> {

              if (weatherApiResponse != null
                  && weatherApiResponse.getForecast() != null
                  && weatherApiResponse.getCurrent() != null) {
                mainMvpView.showFetchedData(weatherApiResponse);
              }
              Log.d("onNextCalled***", "data fetched");
            }, throwable -> {
              Log.d("weatherAPIError***", throwable.getMessage());
              mainMvpView.showError();
            },
            () -> Log.d("weatherAPI***", "completed")));
  }

}


