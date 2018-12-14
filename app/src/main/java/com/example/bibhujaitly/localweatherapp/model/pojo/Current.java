
package com.example.bibhujaitly.localweatherapp.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Current {

    @SerializedName("last_updated_epoch")
    @Expose
    private long lastUpdatedEpoch;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;
    @SerializedName("temp_c")
    @Expose
    private double tempC;
    @SerializedName("temp_f")
    @Expose
    private double tempF;
    @SerializedName("is_day")
    @Expose
    private long isDay;
    @SerializedName("condition")
    @Expose
    private Condition condition;
    @SerializedName("wind_mph")
    @Expose
    private double windMph;
    @SerializedName("wind_kph")
    @Expose
    private double windKph;
    @SerializedName("wind_degree")
    @Expose
    private long windDegree;
    @SerializedName("wind_dir")
    @Expose
    private String windDir;
    @SerializedName("pressure_mb")
    @Expose
    private double pressureMb;
    @SerializedName("pressure_in")
    @Expose
    private double pressureIn;
    @SerializedName("precip_mm")
    @Expose
    private double precipMm;
    @SerializedName("precip_in")
    @Expose
    private double precipIn;
    @SerializedName("humidity")
    @Expose
    private long humidity;
    @SerializedName("cloud")
    @Expose
    private long cloud;
    @SerializedName("feelslike_c")
    @Expose
    private double feelslikeC;
    @SerializedName("feelslike_f")
    @Expose
    private double feelslikeF;
    @SerializedName("vis_km")
    @Expose
    private double visKm;
    @SerializedName("vis_miles")
    @Expose
    private double visMiles;
    @SerializedName("uv")
    @Expose
    private double uv;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Current() {
    }

    /**
     * 
     * @param tempC
     * @param feelslikeC
     * @param visKm
     * @param condition
     * @param pressureMb
     * @param windKph
     * @param precipMm
     * @param lastUpdated
     * @param isDay
     * @param visMiles
     * @param windMph
     * @param windDegree
     * @param humidity
     * @param lastUpdatedEpoch
     * @param uv
     * @param precipIn
     * @param cloud
     * @param pressureIn
     * @param tempF
     * @param feelslikeF
     * @param windDir
     */
    public Current(long lastUpdatedEpoch, String lastUpdated, double tempC, double tempF, long isDay, Condition condition, double windMph, double windKph, long windDegree, String windDir, double pressureMb, double pressureIn, double precipMm, double precipIn, long humidity, long cloud, double feelslikeC, double feelslikeF, double visKm, double visMiles, double uv) {
        super();
        this.lastUpdatedEpoch = lastUpdatedEpoch;
        this.lastUpdated = lastUpdated;
        this.tempC = tempC;
        this.tempF = tempF;
        this.isDay = isDay;
        this.condition = condition;
        this.windMph = windMph;
        this.windKph = windKph;
        this.windDegree = windDegree;
        this.windDir = windDir;
        this.pressureMb = pressureMb;
        this.pressureIn = pressureIn;
        this.precipMm = precipMm;
        this.precipIn = precipIn;
        this.humidity = humidity;
        this.cloud = cloud;
        this.feelslikeC = feelslikeC;
        this.feelslikeF = feelslikeF;
        this.visKm = visKm;
        this.visMiles = visMiles;
        this.uv = uv;
    }

    public long getLastUpdatedEpoch() {
        return lastUpdatedEpoch;
    }

    public void setLastUpdatedEpoch(long lastUpdatedEpoch) {
        this.lastUpdatedEpoch = lastUpdatedEpoch;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public double getTempF() {
        return tempF;
    }

    public void setTempF(double tempF) {
        this.tempF = tempF;
    }

    public long getIsDay() {
        return isDay;
    }

    public void setIsDay(long isDay) {
        this.isDay = isDay;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public double getWindMph() {
        return windMph;
    }

    public void setWindMph(double windMph) {
        this.windMph = windMph;
    }

    public double getWindKph() {
        return windKph;
    }

    public void setWindKph(double windKph) {
        this.windKph = windKph;
    }

    public long getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(long windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public double getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(double pressureMb) {
        this.pressureMb = pressureMb;
    }

    public double getPressureIn() {
        return pressureIn;
    }

    public void setPressureIn(double pressureIn) {
        this.pressureIn = pressureIn;
    }

    public double getPrecipMm() {
        return precipMm;
    }

    public void setPrecipMm(double precipMm) {
        this.precipMm = precipMm;
    }

    public double getPrecipIn() {
        return precipIn;
    }

    public void setPrecipIn(double precipIn) {
        this.precipIn = precipIn;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public long getCloud() {
        return cloud;
    }

    public void setCloud(long cloud) {
        this.cloud = cloud;
    }

    public double getFeelslikeC() {
        return feelslikeC;
    }

    public void setFeelslikeC(double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public double getFeelslikeF() {
        return feelslikeF;
    }

    public void setFeelslikeF(double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

    public double getVisKm() {
        return visKm;
    }

    public void setVisKm(double visKm) {
        this.visKm = visKm;
    }

    public double getVisMiles() {
        return visMiles;
    }

    public void setVisMiles(double visMiles) {
        this.visMiles = visMiles;
    }

    public double getUv() {
        return uv;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

}
