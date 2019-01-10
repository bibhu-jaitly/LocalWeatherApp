package com.example.bibhujaitly.localweatherapp.ui.presenter;

import android.util.Log;
import com.example.bibhujaitly.localweatherapp.model.network.APIHelper;
import com.example.bibhujaitly.localweatherapp.ui.contracts.MainContract;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

  //@Inject
  MainContract.MainMvpView mainMvpView;

  private APIHelper apiHelper;
  private CompositeDisposable compositeDisposable;

  @Inject
  public MainPresenter(APIHelper helper) {
    this.apiHelper = helper;
  }

  @Override
  public void requestWeatherData(String city, int days) {
    mainMvpView.showProgress();
    compositeDisposable.add(apiHelper.getWeatherApi(city, days)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(response -> {
          if (response != null
              && response.getForecast() != null
              && response.getCurrent() != null) {
            mainMvpView.showFetchedData(response);
          }
          // Log.d("onSucc****", "****");
        }, throwable -> Log.d("weatherErr***", throwable.getMessage())));
  }

  @Override
  public void getCompositeDisposable(CompositeDisposable disposable) {
    compositeDisposable = disposable;
  }

  public void attachView(MainContract.MainMvpView view) {
    mainMvpView = view;
  }

  public void detachView() {
    mainMvpView = null;
  }
}


