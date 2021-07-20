package android.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.example.assignment3.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    RecyclerAdapter recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        ArrayList<TimeInfo> arrayList = new ArrayList<>();


        recyclerAdapter=new RecyclerAdapter(arrayList);
        binding.recyclerView.setAdapter(recyclerAdapter);

        binding.button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                viewModel.setTimeInfo();
                viewModel.returnList(arrayList);
            }
        });


        Observer<ArrayList<TimeInfo>> timeInfoObserver = new Observer<ArrayList<TimeInfo>>() {
            @Override
            public void onChanged(ArrayList<TimeInfo> timeInfos) {
                recyclerAdapter=new RecyclerAdapter(arrayList);
                binding.recyclerView.setAdapter(recyclerAdapter);
            }

            /*@Override
            public void onChanged(TimeInfo timeInfo) {
                //binding.setTimeInfo(timeInfo);

                //viewModel.returnList(arrayList);
                recyclerAdapter=new RecyclerAdapter(arrayList);
                binding.recyclerView.setAdapter(recyclerAdapter);
            }*/
        };

        viewModel.timeData.observe(this, timeInfoObserver);


        /*recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerAdapter=new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);*/

    }


}