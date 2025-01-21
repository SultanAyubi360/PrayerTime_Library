package com.sultanayubi.prayertimeapp.Models;

public class PrayerModel {
    private String imgurl;
    private String prayerName;
    private String prayerTime;

    public PrayerModel(String imgurl, String prayerName, String prayerTime) {
        this.imgurl = imgurl;
        this.prayerName = prayerName;
        this.prayerTime = prayerTime;
    }

    public String getImgurl() {
        return imgurl;
    }

    public String getPrayerName() {
        return prayerName;
    }

    public String getPrayerTime() {
        return prayerTime;
    }
}