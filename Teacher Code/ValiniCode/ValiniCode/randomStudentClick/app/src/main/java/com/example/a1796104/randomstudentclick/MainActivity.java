package com.example.a1796104.randomstudentclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView firstTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void randomStudent(View view){

        String studentId[]={"1", "2" ,"3", "4", "5"};
        Random r = new Random();
        int j = r.nextInt(studentId.length);


        firstTextView =  findViewById(R.id.firstTextView);
        firstTextView.setText("Student Number: " + studentId[j]);




        List<Pair<Integer, String>> studentList = new ArrayList<Pair<Integer, String>>();
        studentList.add(new Pair<Integer, String>(2, "Sam"));
        studentList.add(new Pair<Integer, String>(3, "James"));
        studentList.add(new Pair<Integer, String>(4, "Jane"));
        studentList.add(new Pair<Integer, String>(5, "Peter"));
        Random s = new Random();






    }



}
