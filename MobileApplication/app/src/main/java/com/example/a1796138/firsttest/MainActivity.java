package com.example.a1796138.firsttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView firstTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstTextView = findViewById(R.id.firstTextView);
        firstTextView.append("dfgdfs");
        //firstTextView.isShown();
    }
}
