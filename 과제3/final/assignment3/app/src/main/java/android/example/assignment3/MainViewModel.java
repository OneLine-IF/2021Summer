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
    MutableLiveData<ArrayList<TimeInfo>> timeData = new MutableLiveData<>();

    public void setTimeInfo() {
        ArrayList<TimeInfo> timeInfo = getTimeInfo();
        timeData.setValue(timeInfo);
    }

    ArrayList<TimeInfo> arrayList = new ArrayList<>();
    private ArrayList<TimeInfo> getTimeInfo() {
        arrayList.clear();
        TimeInfo timeInfo = new TimeInfo();


        TimeZone timeZone;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH시 mm분 ss초");


        timeSet("Asia/Seoul");
        timeSet("America/Los_Angles");
        timeSet("Canada/Pacific");
        timeSet("Canada/Central");
        timeSet("Europe/London");
        timeSet("Europe/Amsterdam");
        timeSet("Europe/Berlin");
        timeSet("Europe/Budapest");
        timeSet("Europe/Madrid");
        timeSet("Europe/Monaco");
        timeSet("Europe/Rome");
        timeSet("Asia/Dubai");
        timeSet("Singapore");
        timeSet("Asia/Colombo");
        timeSet("Asia/Macao");
        
        return arrayList;
    }

    public void timeSet(String countryName){
        TimeInfo timeInfo = new TimeInfo();


        TimeZone timeZone;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH시 mm분 ss초");


        timeZone = TimeZone.getTimeZone(countryName);
        df.setTimeZone(timeZone);
        timeInfo.setCurrentTime(df.format(date));
        timeInfo.setCountry(timeZone.getID());
        arrayList.add(new TimeInfo(timeInfo.currentTime, timeInfo.country));
    }

}
