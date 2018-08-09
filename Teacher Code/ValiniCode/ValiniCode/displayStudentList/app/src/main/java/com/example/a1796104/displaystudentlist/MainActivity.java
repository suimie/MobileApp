package com.example.a1796104.displaystudentlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView firstTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String studentIds[]={"1122333", "23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","1122333", "23333" ,"333333", "433333", "2333333","id"};
        Random r = new Random();
        firstTextView =  findViewById(R.id.firstTextView);
        firstTextView.setText("Student Number: " +  "\n");
        for (String studentId : studentIds) {

            firstTextView.append(  studentId + "\n");
        }

    }
}
