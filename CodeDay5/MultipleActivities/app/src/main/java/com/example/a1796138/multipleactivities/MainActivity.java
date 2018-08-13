package com.example.a1796138.multipleactivities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSecondActivity(View view){
        Intent intentToStartActivity = new Intent(MainActivity.this, Second.class);
        intentToStartActivity.putExtra(Intent.EXTRA_TEXT, "Sent from Main Activity");
        intentToStartActivity.putExtra(Intent.EXTRA_SUBJECT, "Comp science");
        startActivity(intentToStartActivity);
    }

    public void startWebpage(View view){
        Uri uri = Uri.parse("http://www.johnabbott.qc.ca");
        Intent openWebPageIntent = new Intent(Intent.ACTION_VIEW,uri);

        if(openWebPageIntent.resolveActivity(getPackageManager()) != null)
            startActivity(openWebPageIntent);
    }
}
