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
    //int hour;
    //int minute;
    //String showing_time;


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

    /*public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }


    public void setTime(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }*/

    /*public String getShowing_time() {
        return showing_time;
    }
    public void setShowing_time(String showing_time) {
        this.showing_time = hour+"시 "+minute+"분";
    }

    public void timeZone(){
        TimeZone timeZone;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH시 mm분");
        timeZone=TimeZone.getTimeZone("Asia/Seoul");
        df.setTimeZone(timeZone);
        Log.d(TAG, timeZone.getDisplayName()+df.format(date));
        timeZone=TimeZone.getTimeZone("America/Los_Angles");
        df.setTimeZone(timeZone);
        Log.d(TAG, timeZone.getDisplayName()+df.format(date));
    }*/
}
