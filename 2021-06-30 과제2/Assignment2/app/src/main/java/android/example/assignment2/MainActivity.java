package android.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<BookInfo> list;

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    Button title_sort_button, writer_sort_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title_sort_button = (Button) findViewById(R.id.title_sort_button);
        writer_sort_button = (Button) findViewById(R.id.writer_sort_button);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        list = new ArrayList<>();

        list.add(new BookInfo("명화가 내게 묻다", "최혜진"));
        list.add(new BookInfo("나의 친애하는 적", "허지웅"));
        list.add(new BookInfo("위대한 개츠비", "스콧 피츠제럴드"));
        list.add(new BookInfo("이산수학", "조현진"));
        list.add(new BookInfo("위로의 그림책", "박재규"));


        recyclerAdapter = new RecyclerAdapter(list);
        recyclerView.setAdapter(recyclerAdapter);



    }


    public void onClick_title(View view) {
        Comparator<BookInfo> titleASC = new Comparator<BookInfo>() {
            @Override
            public int compare(BookInfo o1, BookInfo o2) {

                return o1.getTitle().compareTo(o2.getTitle());
            }
        };
        Collections.sort(list, titleASC);
        recyclerAdapter.notifyDataSetChanged();
    }

    public void onClick_writer(View view) {
        Comparator<BookInfo> titleASC = new Comparator<BookInfo>() {
            @Override
            public int compare(BookInfo o1, BookInfo o2) {

                return o1.getWriter().compareTo(o2.getWriter());
            }
        };
        Collections.sort(list, titleASC);
        recyclerAdapter.notifyDataSetChanged();
    }



}

