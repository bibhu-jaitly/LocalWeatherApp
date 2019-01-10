package com.example.bibhujaitly.localweatherapp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.bibhujaitly.localweatherapp.R;
import com.example.bibhujaitly.localweatherapp.model.pojo.Forecastday;
import com.example.bibhujaitly.localweatherapp.utils.DateUtil;
import java.util.List;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.ViewHolder> {

  private Context context;
  private List<Forecastday> foreCastList;

  public WeatherListAdapter(Context context) {
    this.context = context;
  }

  public void setForeCastList(List<Forecastday> forecastday) {
    this.foreCastList = forecastday;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(context)
        .inflate(R.layout.adapter_weather_item, viewGroup, false);

    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
    Forecastday forecast = foreCastList.get(i + 1);
    if (forecast != null) {
      viewHolder.day.setText(DateUtil.getDayFromDate(forecast.getDate()));
      viewHolder.temperature.setText(String.format("%s C", forecast.getDay().getAvgtempC()));
    }
  }

  @Override
  public int getItemCount() {
    return foreCastList.size() - 1;
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    TextView temperature, day;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      day = itemView.findViewById(R.id.day);
      temperature = itemView.findViewById(R.id.temperature);
    }
  }
}
