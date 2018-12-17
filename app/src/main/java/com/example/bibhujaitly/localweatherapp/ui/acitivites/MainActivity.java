package com.example.bibhujaitly.localweatherapp.ui.acitivites;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
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
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class MainActivity extends AppCompatActivity implements MainContract.MainMvpView {

  private long UPDATE_INTERVAL = 5 * 60 * 1000;  /* 5 min */
  private long FASTEST_INTERVAL = 2000; /* 2 sec */

  private RxPermissions rxPermissions;

  //Views declaration
  private RecyclerView weatherRv;
  private TextView currentTemp, currentLocation, retryBtn;
  private ImageView progressImage;
  private FrameLayout weatherListLayout;
  private LinearLayout errorStateContainer;
  private RelativeLayout homeScreenContainer;

  //recyclerview declaration
  private WeatherListAdapter adapter;

  private MainPresenter presenter;
  private String city, DEGREE = "\u00b0";
  private final int days = 5;
  private CompositeDisposable compositeDisposable;
  private FusedLocationProviderClient providerClient;
  private LocationCallback locationCallback;
  private LocationRequest locationRequest;

  private boolean mRequestingLocationUpdates = true;

  public MainActivity() {
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    initComponents();
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initializeViews();
  }

  private void initComponents() {
    rxPermissions = new RxPermissions(MainActivity.this);
    compositeDisposable = new CompositeDisposable();
    presenter = new MainPresenter(this, compositeDisposable);
    providerClient = getFusedLocationProviderClient(this);
    locationRequest = new LocationRequest();
    locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    locationRequest.setInterval(UPDATE_INTERVAL);
    locationRequest.setFastestInterval(FASTEST_INTERVAL);
  }

  private void initializeViews() {
    weatherRv = findViewById(R.id.weather_rv);
    currentTemp = findViewById(R.id.current_temp);
    currentLocation = findViewById(R.id.current_location);
    retryBtn = findViewById(R.id.retry_btn);
    progressImage = findViewById(R.id.loading_icon);
    weatherListLayout = findViewById(R.id.weather_list_layout);
    errorStateContainer = findViewById(R.id.error_state_container);
    homeScreenContainer = findViewById(R.id.home_container);
    requestPermission();
    progressImage.setOnClickListener(v -> requestPermission());
    retryBtn.setOnClickListener(v -> fetchData());
  }

  @Override protected void onResume() {
    super.onResume();
  }

  @Override protected void onPause() {
    //providerClient
    stopLocationRequest();
    super.onPause();
  }

  @Override protected void onDestroy() {
    Observable.just(true)
        .subscribeOn(Schedulers.computation())
        .observeOn(Schedulers.computation())
        .subscribe(new Observer<Boolean>() {
          @Override public void onSubscribe(Disposable d) {

          }

          @Override public void onNext(Boolean aBoolean) {
            compositeDisposable.clear();
          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onComplete() {

          }
        });
    super.onDestroy();
  }

  @Override
  public void showProgress() {
    Animation rotate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation_rotate);
    progressImage.setAnimation(rotate);
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
    progressImage.clearAnimation();
  }

  private void hideError() {
    currentLocation.setVisibility(View.VISIBLE);
    currentTemp.setVisibility(View.VISIBLE);
    errorStateContainer.setVisibility(View.GONE);
    progressImage.setVisibility(View.GONE);
    animateWeatherList();
    weatherListLayout.setVisibility(View.VISIBLE);
    homeScreenContainer.setBackgroundColor(
        getResources().getColor(R.color.home_screen_bg_color));
  }

  @Override
  public void showFetchedData(WeatherApiResponse response) {
    hideProgress();
    hideError();
    currentLocation.setText(response.getLocation().getName());
    currentTemp.setText(String.format("%s%s C", response.getCurrent().getTempC(), DEGREE));
    adapter = new WeatherListAdapter(MainActivity.this, response.getForecast().getForecastday());
    initializeRV();
  }

  private void initializeRV() {
    LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
    weatherRv.setLayoutManager(manager);
    weatherRv.setAdapter(adapter);
    adapter.notifyDataSetChanged();
  }

  private void animateWeatherList() {
    Animation bottomUp = AnimationUtils.loadAnimation(MainActivity.this,
        R.anim.animation_bottom_up);
    weatherListLayout.setAnimation(bottomUp);
  }

  @Override
  public void requestPermission() {
    compositeDisposable.add(rxPermissions.requestEach(Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION)
        .takeWhile(permission -> {
          if (!permission.granted) {
            showPermissionError();
          }
          return permission.granted;
        })
        .subscribe(permission -> {
          if (permission.granted) {
            startLocationUpdate();
          } else {
            showPermissionError();
          }
        }));
  }

  @Override
  public void fetchData() {
    presenter.requestWeatherData(city, days);
  }

  private void showPermissionError() {
    Toast.makeText(this, "Allow access to location for weather data", Toast.LENGTH_SHORT).show();
    progressImage.setVisibility(View.VISIBLE);
    progressImage.clearAnimation();
  }

  public void stopLocationRequest() {
    providerClient.removeLocationUpdates(locationCallback);
  }

  public void startLocationUpdate() {
    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      requestPermission();
      return;
    }
    locationCallback = new LocationCallback() {
      @Override
      public void onLocationResult(LocationResult locationResult) {
        if (locationResult == null) {
          return;
        }
        if (mRequestingLocationUpdates) {
          mRequestingLocationUpdates = false;
          city =
              locationResult.getLastLocation().getLatitude()
                  + ","
                  + locationResult.getLastLocation()
                  .getLongitude();
          fetchData();
        }
        stopLocationRequest();
      }
    };
    providerClient.requestLocationUpdates(locationRequest, locationCallback, null);
  }
}
