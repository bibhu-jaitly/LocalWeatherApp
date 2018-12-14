
package com.example.bibhujaitly.localweatherapp.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day {

    @SerializedName("maxtemp_c")
    @Expose
    private double maxtempC;
    @SerializedName("maxtemp_f")
    @Expose
    private double maxtempF;
    @SerializedName("mintemp_c")
    @Expose
    private double mintempC;
    @SerializedName("mintemp_f")
    @Expose
    private double mintempF;
    @SerializedName("avgtemp_c")
    @Expose
    private double avgtempC;
    @SerializedName("avgtemp_f")
    @Expose
    private double avgtempF;
    @SerializedName("maxwind_mph")
    @Expose
    private double maxwindMph;
    @SerializedName("maxwind_kph")
    @Expose
    private double maxwindKph;
    @SerializedName("totalprecip_mm")
    @Expose
    private double totalprecipMm;
    @SerializedName("totalprecip_in")
    @Expose
    private double totalprecipIn;
    @SerializedName("avgvis_km")
    @Expose
    private double avgvisKm;
    @SerializedName("avgvis_miles")
    @Expose
    private double avgvisMiles;
    @SerializedName("avghumidity")
    @Expose
    private double avghumidity;
    @SerializedName("condition")
    @Expose
    private Condition_ condition;
    @SerializedName("uv")
    @Expose
    private double uv;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Day() {
    }

    /**
     * 
     * @param totalprecipMm
     * @param condition
     * @param avghumidity
     * @param mintempF
     * @param avgtempF
     * @param maxwindMph
     * @param avgvisMiles
     * @param totalprecipIn
     * @param avgtempC
     * @param avgvisKm
     * @param uv
     * @param mintempC
     * @param maxtempC
     * @param maxtempF
     * @param maxwindKph
     */
    public Day(double maxtempC, double maxtempF, double mintempC, double mintempF, double avgtempC, double avgtempF, double maxwindMph, double maxwindKph, double totalprecipMm, double totalprecipIn, double avgvisKm, double avgvisMiles, double avghumidity, Condition_ condition, double uv) {
        super();
        this.maxtempC = maxtempC;
        this.maxtempF = maxtempF;
        this.mintempC = mintempC;
        this.mintempF = mintempF;
        this.avgtempC = avgtempC;
        this.avgtempF = avgtempF;
        this.maxwindMph = maxwindMph;
        this.maxwindKph = maxwindKph;
        this.totalprecipMm = totalprecipMm;
        this.totalprecipIn = totalprecipIn;
        this.avgvisKm = avgvisKm;
        this.avgvisMiles = avgvisMiles;
        this.avghumidity = avghumidity;
        this.condition = condition;
        this.uv = uv;
    }

    public double getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(double maxtempC) {
        this.maxtempC = maxtempC;
    }

    public double getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(double maxtempF) {
        this.maxtempF = maxtempF;
    }

    public double getMintempC() {
        return mintempC;
    }

    public void setMintempC(double mintempC) {
        this.mintempC = mintempC;
    }

    public double getMintempF() {
        return mintempF;
    }

    public void setMintempF(double mintempF) {
        this.mintempF = mintempF;
    }

    public double getAvgtempC() {
        return avgtempC;
    }

    public void setAvgtempC(double avgtempC) {
        this.avgtempC = avgtempC;
    }

    public double getAvgtempF() {
        return avgtempF;
    }

    public void setAvgtempF(double avgtempF) {
        this.avgtempF = avgtempF;
    }

    public double getMaxwindMph() {
        return maxwindMph;
    }

    public void setMaxwindMph(double maxwindMph) {
        this.maxwindMph = maxwindMph;
    }

    public double getMaxwindKph() {
        return maxwindKph;
    }

    public void setMaxwindKph(double maxwindKph) {
        this.maxwindKph = maxwindKph;
    }

    public double getTotalprecipMm() {
        return totalprecipMm;
    }

    public void setTotalprecipMm(double totalprecipMm) {
        this.totalprecipMm = totalprecipMm;
    }

    public double getTotalprecipIn() {
        return totalprecipIn;
    }

    public void setTotalprecipIn(double totalprecipIn) {
        this.totalprecipIn = totalprecipIn;
    }

    public double getAvgvisKm() {
        return avgvisKm;
    }

    public void setAvgvisKm(double avgvisKm) {
        this.avgvisKm = avgvisKm;
    }

    public double getAvgvisMiles() {
        return avgvisMiles;
    }

    public void setAvgvisMiles(double avgvisMiles) {
        this.avgvisMiles = avgvisMiles;
    }

    public double getAvghumidity() {
        return avghumidity;
    }

    public void setAvghumidity(double avghumidity) {
        this.avghumidity = avghumidity;
    }

    public Condition_ getCondition() {
        return condition;
    }

    public void setCondition(Condition_ condition) {
        this.condition = condition;
    }

    public double getUv() {
        return uv;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

}
