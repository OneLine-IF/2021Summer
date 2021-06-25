package android.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1= (Button)findViewById(R.id.button1);
        button2= (Button)findViewById(R.id.button2);
        button3= (Button)findViewById(R.id.button3);
        button4= (Button)findViewById(R.id.button4);
        button5= (Button)findViewById(R.id.button5);
        button6= (Button)findViewById(R.id.button6);
        button7= (Button)findViewById(R.id.button7);
        button8= (Button)findViewById(R.id.button8);
        button9= (Button)findViewById(R.id.button9);
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                if(c==0){
                    //클릭이 안된 상태
                    c++;
                    button1.setBackgroundColor(Color.BLUE);
                }
                else{
                    //클릭이 되어 있던 상태
                    c--;
                    button1.setBackgroundColor(Color.RED);
                }
                break;
            case R.id.button2:
                if(c==0){
                    //클릭이 안된 상태
                    c++;
                    button2.setBackgroundColor(Color.BLUE);
                }
                else{
                    //클릭이 되어 있던 상태
                    c--;
                    button2.setBackgroundColor(Color.RED);
                }

                break;
            case R.id.button3:
                if(c==0){
                    //클릭이 안된 상태
                    c++;
                    button3.setBackgroundColor(Color.BLUE);
                }
                else{
                    //클릭이 되어 있던 상태
                    c--;
                    button3.setBackgroundColor(Color.RED);
                }

                break;
            case R.id.button4:
                if(c==0){
                    //클릭이 안된 상태
                    c++;
                    button4.setBackgroundColor(Color.BLUE);
                }
                else{
                    //클릭이 되어 있던 상태
                    c--;
                    button4.setBackgroundColor(Color.RED);
                }

                break;
            case R.id.button5:
                if(c==0){
                    //클릭이 안된 상태
                    c++;
                    button5.setBackgroundColor(Color.BLUE);
                }
                else{
                    //클릭이 되어 있던 상태
                    c--;
                    button5.setBackgroundColor(Color.RED);
                }

                break;
            case R.id.button6:
                if(c==0){
                    //클릭이 안된 상태
                    c++;
                    button6.setBackgroundColor(Color.BLUE);
                }
                else{
                    //클릭이 되어 있던 상태
                    c--;
                    button6.setBackgroundColor(Color.RED);
                }

                break;
            case R.id.button7:
                if(c==0){
                    //클릭이 안된 상태
                    c++;
                    button7.setBackgroundColor(Color.BLUE);
                }
                else{
                    //클릭이 되어 있던 상태
                    c--;
                    button7.setBackgroundColor(Color.RED);
                }

                break;
            case R.id.button8:
                if(c==0){
                    //클릭이 안된 상태
                    c++;
                    button8.setBackgroundColor(Color.BLUE);
                }
                else{
                    //클릭이 되어 있던 상태
                    c--;
                    button8.setBackgroundColor(Color.RED);
                }

                break;
            case R.id.button9:
                if(c==0){
                    //클릭이 안된 상태
                    c++;
                    button9.setBackgroundColor(Color.BLUE);
                }
                else{
                    //클릭이 되어 있던 상태
                    c--;
                    button9.setBackgroundColor(Color.RED);
                }
                
                break;

        }
    }
}