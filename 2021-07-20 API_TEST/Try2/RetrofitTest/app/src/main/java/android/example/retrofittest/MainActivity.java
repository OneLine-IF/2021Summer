package android.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    APIService apiService;
    EditText titleEditText;
    EditText contentEditText;
    EditText idEditText;
    String title;
    String content;
    String  id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleEditText = findViewById(R.id.title_editText);
        contentEditText = findViewById(R.id.content_edittext);
        idEditText =  findViewById(R.id.id_edittext);
        Button postButton =  findViewById(R.id.post_button);
        Button updateButton = findViewById(R.id.update_button);
        Button deleteButton = findViewById(R.id.delete_button);
        Button getButton = findViewById(R.id.get_button);
        Button allDeleteButton = findViewById(R.id.all_delete_button);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);

        RetrofitClient();


        getButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Call<ArrayList<Notice>> getNotice = apiService.findAll();
                getNotice.enqueue(new Callback<ArrayList<Notice>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Notice>> call, Response<ArrayList<Notice>> response) {
                        recyclerAdapter.setNoticeArrayList(response.body());
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Notice>> call, Throwable t) {
                        Log.e("Error", t.getMessage());
                    }
                });
            }
        });

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                POST();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DELETE();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PUT();
            }
        });

        allDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ALLDELETE();
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

    public void POST(){
        title = titleEditText.getText().toString();
        content = contentEditText.getText().toString();
        Notice notice = new Notice(title, content);
        Call<Void> call = apiService.createUser(notice);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()&&response.body()!=null){
                    //Log.e("연결이 비정상적 : ", "error code : " + response.code());
                    Toast.makeText(MainActivity.this,"연결비정상", Toast.LENGTH_SHORT).show();
                    //Notice notice1 = response.body();
                }else{
                    Toast.makeText(MainActivity.this,"연결성공", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                //Log.e("연결실패", t.getMessage());
                Toast.makeText(MainActivity.this,"연결실패", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void DELETE(){
        id=idEditText.getText().toString();
        Call<Void> call = apiService.deleteNotice(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"연결비정상", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this,"연결성공", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.this,"연결실패", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void PUT(){
        title = titleEditText.getText().toString();
        content = contentEditText.getText().toString();
        id=idEditText.getText().toString();

        Notice notice = new Notice(title, content);
        Call<Notice> call = apiService.putNotice(id, notice);

        call.enqueue(new Callback<Notice>() {
            @Override
            public void onResponse(Call<Notice> call, Response<Notice> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"연결비정상", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this,"연결성공", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Notice> call, Throwable t) {
                Toast.makeText(MainActivity.this,"연결실패", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ALLDELETE() {
            apiService.deleteNotice().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"연결비정상", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this,"연결성공", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.this,"연결실패", Toast.LENGTH_SHORT).show();
            }
        });
    }


}