package com.sultanayubi.prayertimeapp;

import static com.sultanayubi.prayertimeapp.PrayerImageConstants.ASR_URL;
import static com.sultanayubi.prayertimeapp.PrayerImageConstants.DHUHR_URL;
import static com.sultanayubi.prayertimeapp.PrayerImageConstants.FAJR_URL;
import static com.sultanayubi.prayertimeapp.PrayerImageConstants.ISHA_URL;
import static com.sultanayubi.prayertimeapp.PrayerImageConstants.MAGHRIB_URL;
import static com.sultanayubi.prayertimeapp.PrayerImageConstants.SUNRISE_URL;
import static com.sultanayubi.prayertimeapp.PrayerImageConstants.SUNSET_URL;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sultanayubi.prayertimeapp.Models.PrayerModel;
import com.sultanayubi.prayertimelibrary.PrayTime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    RecyclerView live_rv;
    TextView date,city;
    PrayerAdapter prayerAdapter;
    ArrayList<PrayerModel> prayerModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        live_rv = findViewById(R.id.recyclerview);
        date = findViewById(R.id.Date);
        city = findViewById(R.id.city_txt);

        double latitude = 33.5953143;
        double longitude = 73.0412202;//Rawalpindi

        PrayTime prayers = new PrayTime();
        date.setText(prayers.getCurrentDate());

        String locationInfo = prayers.getLocationInfo(this, latitude, longitude);
        if (locationInfo != null) {
            city.setVisibility(View.VISIBLE);
            city.setText(locationInfo);
        } else {
            city.setVisibility(View.GONE);
        }

        double timezone = prayers.getBaseTimeZone();
        Log.d("TimeZoneInfo", "Time Zone Offset (hours): " + timezone);
        // Set calculation method and other parameters
        prayers.setTimeFormat(prayers.Time12); // 12-hour format
        prayers.setCalcMethod(prayers.Karachi); // Calculation method
        prayers.setAsrJuristic(prayers.Hanafi); // Juristic method for Asr
        prayers.setAdjustHighLats(prayers.AngleBased); // Adjust for high latitudes

        // Get the current date
        Calendar cal = Calendar.getInstance();

        // Get prayer times
        ArrayList<String> prayerTimes = prayers.getPrayerTimes(cal, latitude, longitude, timezone);
        ArrayList<String> prayerNames = prayers.getTimeNames();

        prayerModelList = new ArrayList<>();
        for (int i = 0; i < prayerTimes.size(); i++) {
            String imageUrl;
            switch (prayerNames.get(i).toLowerCase()) {
                case "fajr":
                    imageUrl = FAJR_URL;
                    break;
                case "sunrise":
                    imageUrl = SUNRISE_URL;
                    break;
                case "zuhar":
                    imageUrl = DHUHR_URL;
                    break;
                case "asar":
                    imageUrl = ASR_URL;
                    break;
                case "sunset":
                    imageUrl = SUNSET_URL;
                    break;
                case "maghrib":
                    imageUrl = MAGHRIB_URL;
                    break;
                case "isha":
                    imageUrl = ISHA_URL;
                    break;
                default:
                    imageUrl = "";
                    break;
            }
            prayerModelList.add(new PrayerModel(imageUrl, prayerNames.get(i), prayerTimes.get(i)));
        }

        // Set up the RecyclerView
        prayerAdapter = new PrayerAdapter(prayerModelList, this);
        live_rv.setLayoutManager(new LinearLayoutManager(this));
        live_rv.setAdapter(prayerAdapter);

    }

}