package com.example.bibhujaitly.localweatherapp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.example.bibhujaitly.localweatherapp.model.pojo.Forecastday;
import com.example.bibhujaitly.localweatherapp.ui.acitivites.MainActivity;
import java.util.ArrayList;
import java.util.List;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.ViewHolder> {

  private Context context;
  private List<Forecastday> foreCastList;

  public WeatherListAdapter(Context context, List<Forecastday> forecastday) {
    this.context = context;
    foreCastList = forecastday;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

  }

  @Override
  public int getItemCount() {
    return foreCastList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(@NonNull View itemView) {
      super(itemView);
    }
  }
}
