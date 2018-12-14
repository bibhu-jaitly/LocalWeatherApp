
package com.example.bibhujaitly.localweatherapp.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Condition_ {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("code")
    @Expose
    private long code;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Condition_() {
    }

    /**
     * 
     * @param icon
     * @param text
     * @param code
     */
    public Condition_(String text, String icon, long code) {
        super();
        this.text = text;
        this.icon = icon;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

}
