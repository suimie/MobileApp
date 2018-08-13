package com.example.a1796138.multipleactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent intentReceived = getIntent();
        TextView tvChild = findViewById(R.id.child_tv);
        if(intentReceived.hasExtra(Intent.EXTRA_TEXT)){
            String stringRecieved = intentReceived.getStringExtra(Intent.EXTRA_TEXT);
            String stringRecieved2 = intentReceived.getStringExtra(Intent.EXTRA_SUBJECT);
            tvChild.setText(stringRecieved + ", " + stringRecieved2);
        }
    }
}
