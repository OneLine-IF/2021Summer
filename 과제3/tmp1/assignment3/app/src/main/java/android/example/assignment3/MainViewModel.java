package android.example.assignment3;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import static android.content.ContentValues.TAG;

public class MainViewModel extends ViewModel {
    //MutableLiveData<List<TimeInfo>> timeData = new MutableLiveData<>();
    MutableLiveData<TimeInfo> timeData = new MutableLiveData<>();

    public void setTimeInfo() {
        //List<TimeInfo> time = getTimeInfo();
        TimeInfo timeInfo = getTimeInfo();

        timeData.setValue(timeInfo);
    }

    //ArrayList<TimeInfo> list = new ArrayList<>();
    //String currentTime, country;

    private TimeInfo getTimeInfo() {
        TimeInfo timeInfo = new TimeInfo();


        TimeZone timeZone;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH시 mm분");


        timeZone = TimeZone.getTimeZone("Asia/Seoul");
        df.setTimeZone(timeZone);
        timeInfo.setCurrentTime(df.format(date));
        timeInfo.setCountry(timeZone.getDisplayName());
        //timeInfo.add(new TimeInfo(currentTime, timeZone.getDisplayName()));


        timeZone = TimeZone.getTimeZone("America/Los_Angles");
        df.setTimeZone(timeZone);
        //timeInfo.add(new TimeInfo(df.format(date), timeZone.getDisplayName()));

        return timeInfo;
    }


    public void setList(ArrayList<TimeInfo> arrayList) {
        TimeInfo timeInfo = new TimeInfo();


        TimeZone timeZone;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH시 mm분");


        timeZone = TimeZone.getTimeZone("Asia/Seoul");
        df.setTimeZone(timeZone);
        timeInfo.setCurrentTime(df.format(date));
        timeInfo.setCountry(timeZone.getDisplayName());
        arrayList.add(new TimeInfo(df.format(date), timeZone.toString()));

    }
}
