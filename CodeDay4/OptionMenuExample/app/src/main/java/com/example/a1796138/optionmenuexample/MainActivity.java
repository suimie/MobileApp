package com.example.a1796138.optionmenuexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList studentList = new ArrayList();
    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Student s1 = new Student("1234", "Suim park", "123 Street, Montreal, QC");
        studentList.add(s1);
        Student s2 = new Student("1235", "John Abbott", "456 Street, Montreal, QC");
        studentList.add(s2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int selectedItemId = item.getItemId();

        if(selectedItemId == R.id.miStdId){
            Log.i("Main Activity", "Get Random Student ID");
            Random rand = new Random();

            int  n = rand.nextInt(studentList.size());

            Student s = (Student)studentList.get(n);
            String line = "Selected Student ID : " + s.getId();
            tvMsg = findViewById(R.id.textMsg);
            tvMsg.setText(line);
        }else if (selectedItemId == R.id.miStdInfo){
            Log.i("Main Activity", "Get Random Student with information");
            Random rand = new Random();

            int  n = rand.nextInt(studentList.size());

            Student s = (Student)studentList.get(n);
            String line = "Selected Student information : \n" + s.getId() + " : " + s.getName() + " : " + s.getAddress();
            tvMsg = findViewById(R.id.textMsg);
            tvMsg.setText(line);
        }else{
            return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
