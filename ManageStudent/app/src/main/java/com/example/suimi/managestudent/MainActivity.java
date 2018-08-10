package com.example.suimi.managestudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    ArrayList studentList = new ArrayList();
    EditText etSId;
    EditText etSName;
    TextView tvList;
    TextView tvPicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickButton(View view){
        if(studentList.size() <= 0) return;

        Random rand = new Random();

        int  n = rand.nextInt(studentList.size());

        Student s = (Student)studentList.get(n);
        String item = s.getId() + " : " + s.getName();

        tvPicked = findViewById(R.id.tvPickedStudent);
        tvPicked.setText(item);
    }

    public void onClickAddButton(View view){
        etSId = findViewById(R.id.etId);
        String id = etSId.getText().toString();
        etSName = findViewById(R.id.etName);
        String name = etSName.getText().toString();

        if (id.length() == 0 || name.length() == 0) return;

        Student s = new Student(id, name);
        studentList.add(s);
        etSId.setText("");
        etSName.setText("");
        refreshStudentList();
    }

    public void refreshStudentList(){
        Student s = (Student)studentList.get(studentList.size()-1);

        tvList = findViewById(R.id.tvList);
        String item = s.getId() + " : " + s.getName() + "\n";
        tvList.append(item);
    }
}
