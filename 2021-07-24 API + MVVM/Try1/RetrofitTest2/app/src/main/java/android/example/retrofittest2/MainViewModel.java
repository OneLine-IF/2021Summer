package android.example.retrofittest2;

import android.content.Context;
import android.example.retrofittest2.databinding.ActivityMainBinding;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {
    MutableLiveData<ArrayList<Notice>> noticeData_GET = new MutableLiveData<>();
    APIService apiService;

    public void setNoticeData_GET(RecyclerAdapter recyclerAdapter) {

        ArrayList<Notice> notice = getNoticeData_GET(recyclerAdapter);

        noticeData_GET.setValue(notice);
    }

    ArrayList<Notice> arrayList;

    public ArrayList<Notice> getNoticeData_GET(RecyclerAdapter recyclerAdapter) {
        RetrofitClient();
        arrayList = new ArrayList<>();

        Call<ArrayList<Notice>> getNotice = apiService.findAll();
        getNotice.enqueue(new Callback<ArrayList<Notice>>() {
            @Override
            public void onResponse(Call<ArrayList<Notice>> call, Response<ArrayList<Notice>> response) {
                MainActivity.GET_TMP(response);
                arrayList = recyclerAdapter.setNoticeArrayList(response.body());
                if (!response.isSuccessful() && response.body() != null) {
                    Toast.makeText(MainActivity.mContext, "연결비정상", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.mContext, "연결성공", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Notice>> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });


        return arrayList;
    }


    public void setNoticeData_POST(String title, String content) {
        RetrofitClient();
        //Notice notice = getNoticeData_POST(title, content);
        getNoticeData_POST(title, content);
        //noticeData_POST.setValue(notice);
    }


    private Notice getNoticeData_POST(String title, String content) {

        Notice notice = new Notice(title, content);
        Call<Void> call = apiService.createUser(notice);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful() && response.body() != null) {
                    Toast.makeText(MainActivity.mContext, "연결비정상", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.mContext, "연결성공", Toast.LENGTH_SHORT).show();
                    MainActivity.editTextNull();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.mContext, "연결실패", Toast.LENGTH_SHORT).show();
            }
        });

        return notice;
    }

    public void setNoticeData_DELETE(String id) {
        RetrofitClient();
        getNoticeData_DELETE(id);
    }


    private void getNoticeData_DELETE(String id) {
        Call<Void> call = apiService.deleteNotice(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.mContext, "연결비정상", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(MainActivity.mContext, "연결성공", Toast.LENGTH_SHORT).show();
                    MainActivity.editTextNull();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.mContext, "연결실패", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setNoticeData_PUT(String title, String content, String id) {
        RetrofitClient();
        getNoticeData_PUT(title, content, id);
    }

    public void getNoticeData_PUT(String title, String content, String id) {
        Notice notice = new Notice(title, content);
        Call<Void> call = apiService.putNotice(id, notice);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.mContext, "연결비정상", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.mContext, "연결성공", Toast.LENGTH_SHORT).show();
                    MainActivity.editTextNull();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.mContext, "연결실패", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void  setNoticeData_ALLDELETE(){
        RetrofitClient();
        getNoticeData_ALLDELETE();
    }

    public void getNoticeData_ALLDELETE(){
        apiService.deleteNotice().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.mContext, "연결비정상", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.mContext, "연결성공", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.mContext, "연결실패", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://interface-app-dev.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(APIService.class);
    }
}
