package android.example.retrofittest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.example.retrofittest2.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerAdapter recyclerAdapter;
    private static ActivityMainBinding binding;
    APIService apiService;
    String title;
    String content;
    String id;
    MainViewModel viewModel;
    public  static Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GET();
            }
        });
        binding.postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                POST();
            }
        });

        binding.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DELETE();
            }
        });

        binding.updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PUT();
            }
        });

        binding.allDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ALLDELETE();
            }
        });

        Observer<ArrayList<Notice>> noticeObserver = new Observer<ArrayList<Notice>>() {
            public void onChanged(ArrayList<Notice> notice) {
                recyclerAdapter = new RecyclerAdapter(notice);
                binding.recyclerview.setAdapter(recyclerAdapter);
            }
        };

        viewModel.noticeData_GET.observe(this, noticeObserver);

    }

    private void GET() {
        viewModel.setNoticeData_GET();
    }

    public void POST() {
        title = binding.titleEditText.getText().toString();
        content = binding.contentEdittext.getText().toString();

        viewModel.setNoticeData_POST(title, content);

    }

    public void DELETE() {
        id = binding.idEdittext.getText().toString();

        viewModel.setNoticeData_DELETE(id);
    }

    public void PUT() {
        title = binding.titleEditText.getText().toString();
        content = binding.contentEdittext.getText().toString();
        id = binding.idEdittext.getText().toString();

        viewModel.setNoticeData_PUT(title, content, id);


    }

    public void ALLDELETE() {
        viewModel.setNoticeData_ALLDELETE();
    }

    public static void editTextNull(){
        binding.idEdittext.setText(null);
        binding.titleEditText.setText(null);
        binding.contentEdittext.setText(null);
    }

    public static void toastMessageRes(Response<Void> response){
        if (!response.isSuccessful() && response.body() != null) {
            Toast.makeText(MainActivity.mContext, "연결비정상", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.mContext, "연결성공", Toast.LENGTH_SHORT).show();
            editTextNull();
        }
    }

    public static void toastMessageFail(){
        Toast.makeText(MainActivity.mContext, "연결실패", Toast.LENGTH_SHORT).show();
    }

}