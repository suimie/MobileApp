package com.example.a1796104.buttononclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView counterTV;

    static int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void displayStudent(View view){
    counterTV=findViewById(R.id.firstTextView);
    counter++;
    counterTV.setText(Integer.toString(counter));


    }
}
