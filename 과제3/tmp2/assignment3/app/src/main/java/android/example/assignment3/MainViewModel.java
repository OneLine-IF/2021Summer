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
    MutableLiveData<ArrayList<TimeInfo>> timeData = new MutableLiveData<>();

    public void setTimeInfo() {
        ArrayList<TimeInfo> timeInfo = getTimeInfo();
        //setList(timeInfo);
        timeData.setValue(timeInfo);
    }

    ArrayList<TimeInfo> arrayList = new ArrayList<>();
    private ArrayList<TimeInfo> getTimeInfo() {
        arrayList.clear();
        TimeInfo timeInfo = new TimeInfo();


        TimeZone timeZone;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH시 mm분 ss초");


        timeZone = TimeZone.getTimeZone("Asia/Seoul");
        df.setTimeZone(timeZone);
        timeInfo.setCurrentTime(df.format(date));
        timeInfo.setCountry(timeZone.getDisplayName());
        arrayList.add(new TimeInfo(timeInfo.currentTime, timeInfo.country));


        timeZone = TimeZone.getTimeZone("America/Los_Angles");
        df.setTimeZone(timeZone);
        timeInfo.setCurrentTime(df.format(date));
        timeInfo.setCountry(timeZone.getDisplayName());
        arrayList.add(new TimeInfo(timeInfo.currentTime, timeInfo.country));

        //arrayList.add(new TimeInfo("4:15", "미국"));

        return arrayList;
    }


    /*public void setList(TimeInfo timeInfo) {
        arrayList.add(new TimeInfo(timeInfo.currentTime, timeInfo.country));
    }*/

    public void returnList(ArrayList<TimeInfo> arrayList){
        this.arrayList=arrayList;
    }
}
