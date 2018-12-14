
package com.example.bibhujaitly.localweatherapp.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("tz_id")
    @Expose
    private String tzId;
    @SerializedName("localtime_epoch")
    @Expose
    private long localtimeEpoch;
    @SerializedName("localtime")
    @Expose
    private String localtime;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param region
     * @param localtime
     * @param tzId
     * @param lon
     * @param localtimeEpoch
     * @param name
     * @param lat
     * @param country
     */
    public Location(String name, String region, String country, double lat, double lon, String tzId, long localtimeEpoch, String localtime) {
        super();
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.tzId = tzId;
        this.localtimeEpoch = localtimeEpoch;
        this.localtime = localtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTzId() {
        return tzId;
    }

    public void setTzId(String tzId) {
        this.tzId = tzId;
    }

    public long getLocaltimeEpoch() {
        return localtimeEpoch;
    }

    public void setLocaltimeEpoch(long localtimeEpoch) {
        this.localtimeEpoch = localtimeEpoch;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

}
