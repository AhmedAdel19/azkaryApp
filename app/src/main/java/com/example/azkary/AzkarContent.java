package com.example.azkary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AzkarContent {
    @SerializedName("zekr")
    @Expose
    private String zekr;
    @SerializedName("repeat")
    @Expose
    private Integer repeat;
    @SerializedName("bless")
    @Expose
    private String bless;

    public AzkarContent(String zekr,String bless ,Integer repeat)
    {
        this.zekr = zekr;
        this.repeat = repeat;
        this.bless = bless;
    }

    public String getZekr() {
        return zekr;
    }

    public void setZekr(String zekr) {
        this.zekr = zekr;
    }

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    public String getBless() {
        return bless;
    }

    public void setBless(String bless) {
        this.bless = bless;
    }
}
