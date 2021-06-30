package android.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.SearchManager;
import android.content.Intent;
import android.example.assignment2.databinding.ActivityBookInfoBinding;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class BookInfoActivity extends AppCompatActivity {
    private ActivityBookInfoBinding bookInfoBinding;

    Button button;
    String title;
    String writer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_book_info);
        final  BookInfo bookInfo = new BookInfo();

        Intent intent = getIntent();


        title = intent.getExtras().getString("title");
        bookInfo.setTitle(title.toString());
        bookInfoBinding.setBookInfo(bookInfo);


        writer = intent.getExtras().getString("writer");
        bookInfo.setWriter(writer.toString());
        bookInfoBinding.setBookInfo(bookInfo);



    }


    public void onClick_Search(View view) throws UnsupportedEncodingException {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://search.naver.com/search.naver?query="+title));

        //intent.putExtra(SearchManager.QUERY, title);
        startActivity(intent);
    }
}