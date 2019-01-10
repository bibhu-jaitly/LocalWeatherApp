package com.example.bibhujaitly.localweatherapp.dagger.component;

import com.example.bibhujaitly.localweatherapp.dagger.module.ActivityModule;
import com.example.bibhujaitly.localweatherapp.ui.acitivites.MainActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {ActivityModule.class })
public interface ActivityComponent {

  void inject(MainActivity mainActivity);

  //MainPresenter getPresenter();

}
