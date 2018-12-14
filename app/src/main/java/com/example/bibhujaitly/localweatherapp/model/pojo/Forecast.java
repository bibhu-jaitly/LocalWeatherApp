
package com.example.bibhujaitly.localweatherapp.model.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("forecastday")
    @Expose
    private List<Forecastday> forecastday = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Forecast() {
    }

    /**
     * 
     * @param forecastday
     */
    public Forecast(List<Forecastday> forecastday) {
        super();
        this.forecastday = forecastday;
    }

    public List<Forecastday> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }

}
