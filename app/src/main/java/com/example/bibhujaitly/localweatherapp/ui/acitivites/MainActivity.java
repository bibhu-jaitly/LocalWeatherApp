package com.example.bibhujaitly.localweatherapp.ui.acitivites;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bibhujaitly.localweatherapp.R;
import com.example.bibhujaitly.localweatherapp.model.pojo.WeatherApiResponse;
import com.example.bibhujaitly.localweatherapp.ui.adapter.WeatherListAdapter;
import com.example.bibhujaitly.localweatherapp.ui.contracts.MainContract;
import com.example.bibhujaitly.localweatherapp.ui.presenter.MainPresenter;
import com.jakewharton.rxbinding2.view.RxView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity implements MainContract.MainMvpView {

  private final RxPermissions rxPermissions = new RxPermissions(this);

  //Views declaration
  private RecyclerView weatherRv;
  private TextView currentTemp, currentLocation, retryBtn;
  private ImageView progressImage;
  private View weatherListLayout;
  private LinearLayout errorStateContainer;
  private RelativeLayout homeScreenContainer;

  //recyclerview declaration
  private WeatherListAdapter adapter;

  private MainPresenter presenter;
  private String city;
  private final int days = 4;

  public MainActivity() {
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeViews();
  }

  @SuppressLint("CheckResult")
  private void initializeViews() {
    presenter = new MainPresenter(this);
    weatherRv = findViewById(R.id.weather_rv);
    currentTemp = findViewById(R.id.current_temp);
    currentLocation = findViewById(R.id.current_location);
    retryBtn = findViewById(R.id.retry_btn);
    progressImage = findViewById(R.id.loading_icon);
    weatherListLayout = findViewById(R.id.weather_list_layout);
    errorStateContainer = findViewById(R.id.error_state_container);
    homeScreenContainer = findViewById(R.id.home_container);
    RxView.clicks(retryBtn)
        .compose(rxPermissions.ensure(Manifest.permission.ACCESS_FINE_LOCATION))
        .subscribe(granted -> {
          if (granted) {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            showProgress();
            presenter.requestWeatherData(city, days);
          }
        });
  }

  @Override
  public void showProgress() {
    progressImage.setVisibility(View.VISIBLE);
    errorStateContainer.setVisibility(View.GONE);
    currentLocation.setVisibility(View.GONE);
    currentTemp.setVisibility(View.GONE);
    weatherListLayout.setVisibility(View.GONE);
    homeScreenContainer.setBackgroundColor(getResources().getColor(R.color.home_screen_bg_color));
  }

  @Override
  public void showError() {
    hideProgress();
    currentLocation.setVisibility(View.GONE);
    currentTemp.setVisibility(View.GONE);
    errorStateContainer.setVisibility(View.VISIBLE);
    progressImage.setVisibility(View.GONE);
    weatherListLayout.setVisibility(View.GONE);
    homeScreenContainer.setBackgroundColor(
        getResources().getColor(R.color.error_state_home_bg_color));
  }

  @Override
  public void hideProgress() {
    progressImage.setVisibility(View.GONE);
  }

  @Override
  public void showFetchedData(WeatherApiResponse response) {
    adapter = new WeatherListAdapter(MainActivity.this, response.getForecast().getForecastday());
    initializeRV();
  }

  private void initializeRV() {
    LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
    weatherRv.setLayoutManager(manager);
    weatherRv.setAdapter(adapter);
    adapter.notifyDataSetChanged();
  }
}
