package android.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText titleEditText = findViewById(R.id.title_editText);
        EditText contentEditText = findViewById(R.id.content_edittext);
        EditText idEditText =  findViewById(R.id.id_edittext);
        Button postButton =  findViewById(R.id.post_button);
        Button updateButton = findViewById(R.id.update_button);
        Button deleteButton = findViewById(R.id.delete_button);
        Button getButton = findViewById(R.id.get_button);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);

        RetrofitClient();


        EditText titleEdittext = (EditText)findViewById(R.id.title_editText);
        EditText contentEdittext = (EditText)findViewById(R.id.content_edittext);
        String title = titleEdittext.getText().toString();
        String content = contentEdittext.getText().toString();
        String  id = idEditText.getText().toString();
        //int id = Integer.parseInt(idString);

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
                Notice notice = new Notice(title, content);
                Call<Notice> call = apiService.createUser(notice);

                call.enqueue(new Callback<Notice>() {
                    @Override
                    public void onResponse(Call<Notice> call, Response<Notice> response) {
                        if(response.isSuccessful()&&response.body()!=null){
                            //Log.e("????????? ???????????? : ", "error code : " + response.code());
                            Toast.makeText(MainActivity.this,"????????????", Toast.LENGTH_SHORT).show();
                            Notice notice1 = response.body();
                        }else{
                            Toast.makeText(MainActivity.this,"???????????????", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Notice> call, Throwable t) {
                        //Log.e("????????????", t.getMessage());
                        Toast.makeText(MainActivity.this,"????????????", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Void> call = apiService.deleteNotice(id);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(MainActivity.this,"???????????????", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(MainActivity.this,"????????????", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"????????????", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notice notice = new Notice(title, content);
                Call<Notice> call = apiService.putNotice(id, notice);

                call.enqueue(new Callback<Notice>() {
                    @Override
                    public void onResponse(Call<Notice> call, Response<Notice> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(MainActivity.this,"???????????????", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(MainActivity.this,"????????????", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Notice> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"????????????", Toast.LENGTH_SHORT).show();
                    }
                });
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