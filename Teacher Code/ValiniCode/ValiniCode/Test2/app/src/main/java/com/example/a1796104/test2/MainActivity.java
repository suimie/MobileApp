package com.example.a1796104.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView firstTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String studentId[]={"1", "2" ,"3"};
        Random r = new Random();
        int j = r.nextInt(studentId.length);
        System.out.println(studentId[j]);

        firstTextView = (TextView) findViewById(R.id.firstTextView);
        firstTextView.setText("Student Number: " + studentId[j]);
        firstTextView.isShown();


    }



}
