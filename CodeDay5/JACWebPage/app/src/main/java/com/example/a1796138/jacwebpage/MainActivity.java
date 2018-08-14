package com.example.a1796138.jacwebpage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        if(selectedItemId == R.id.showmap){
            Uri uri = Uri.parse("geo:45.406170, -73.941851?z=15");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }else if (selectedItemId == R.id.showwebsite){
            Uri uri = Uri.parse("http://www.johnabbott.qc.ca");
            Intent openWebPageIntent = new Intent(Intent.ACTION_VIEW,uri);

            if(openWebPageIntent.resolveActivity(getPackageManager()) != null)
                startActivity(openWebPageIntent);
        }else if (selectedItemId == R.id.showinfo) {
            Intent intentToJACInfoActivity = new Intent(MainActivity.this, JACInfo.class);
            //intentToJACInfoActivity.putExtra(Intent.EXTRA_TEXT, "Sent from Main Activity");
            //intentToJACInfoActivity.putExtra(Intent.EXTRA_SUBJECT, "Comp science");
            
            startActivity(intentToJACInfoActivity);
        }else{
            return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
