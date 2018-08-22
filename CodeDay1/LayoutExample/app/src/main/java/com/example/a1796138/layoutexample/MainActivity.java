package com.example.a1796138.layoutexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button2 = findViewById(R.id.button2);
        button2.setPadding(100, 200, 100, 200);
        Log.i("TEST", "\n[ON Create]getPaddingLeft() : " + button2.getPaddingLeft() + " | getPaddingRight() : " + button2.getPaddingRight());
        Log.i("TEST", "\n[ON Create]getPaddingTop() : " + button2.getPaddingTop() + " | getPaddingBottom() : " + button2.getPaddingBottom());

        Log.i("TEST", "\ngetMeasuredWidth() : " + button2.getMeasuredWidth() + " | getMeasuredHeight() : " + button2.getMeasuredHeight());
        Log.i("TEST", "\ngetWidth() : " + button2.getWidth() + " | getHeight() : " + button2.getHeight());
        button2.post(new Runnable() {

            @Override
            public void run() {

                Log.i("TEST", "\ngetMeasuredWidth() : " + button2.getMeasuredWidth() + " | getMeasuredHeight() : " + button2.getMeasuredHeight());
                Log.i("TEST", "\ngetWidth() : " + button2.getWidth() + " | getHeight() : " + button2.getHeight());
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Button button2 = findViewById(R.id.button2);
//        Log.i("TEST", "\ngetMeasuredWidth() : " + button2.getMeasuredWidth() + " | getMeasuredHeight() : " + button2.getMeasuredHeight());
//        Log.i("TEST", "\ngetWidth() : " + button2.getWidth() + " | getHeight() : " + button2.getHeight());

    }

    public void clickButton(View view){
        Button button2 = findViewById(R.id.button2);

        Log.i("TEST", "\ngetMeasuredWidth() : " + button2.getMeasuredWidth() + " | getMeasuredHeight() : " + button2.getMeasuredHeight());
        Log.i("TEST", "\ngetWidth() : " + button2.getWidth() + " | getHeight() : " + button2.getHeight());

    }
}
