package android.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                button1.setBackgroundColor(Color.rgb(255, 0, 0));
                break;
            case R.id.button2:
                button2.setBackgroundColor(Color.rgb(255, 0, 0));
                break;
            case R.id.button3:
                button3.setBackgroundColor(Color.rgb(255, 0, 0));
                break;
            case R.id.button4:
                button4.setBackgroundColor(Color.rgb(255, 0, 0));
                break;
            case R.id.button5:
                button5.setBackgroundColor(Color.rgb(255, 0, 0));
                break;
            case R.id.button6:
                button6.setBackgroundColor(Color.rgb(255, 0, 0));
                break;
            case R.id.button7:
                button7.setBackgroundColor(Color.rgb(255, 0, 0));
                break;
            case R.id.button8:
                button8.setBackgroundColor(Color.rgb(255, 0, 0));
                break;
            case R.id.button9:
                button9.setBackgroundColor(Color.rgb(255, 0, 0));
                break;

        }
    }
}