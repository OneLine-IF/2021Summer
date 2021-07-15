package android.example.assignment3;

import android.nfc.Tag;
import android.util.Log;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static android.content.ContentValues.TAG;

public class TimeInfo {
    String currentTime, country;

    TimeInfo(){}

    TimeInfo(String currentTime, String country){
        this.currentTime=currentTime;
        this.country=country;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
