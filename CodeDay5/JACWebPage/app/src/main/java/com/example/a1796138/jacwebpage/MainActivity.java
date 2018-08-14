package com.example.a1796138.jacwebpage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final String GAME_STATE_KEY = "STATE";
    static final String TEXT_VIEW_KEY = "GOOD";
    String mGameState = "ABC";

    TextView mTextView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Suim", "On Create");

        mTextView = findViewById(R.id.textView);
    }

    @Override
    protected void onStart (){
        super.onStart();
        Log.i("Suim", "On Start");
    }

    @Override
    protected  void onResume(){
        super.onResume();
        Log.i("Suim", "On Resume");

    }
    @Override
    protected void onPause (){
        super.onPause();
        Log.i("Suim", "On Pause");
    }

    @Override
    protected  void onStop(){
        super.onStop();
        Log.i("Suim", "On Stop");

    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Log.i("Suim", "On Destroy");

    }

    @Override
    protected  void onRestart(){
        super.onRestart();
        Log.i("Suim", "On Restart");

    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mTextView.append("ABC");
        outState.putString(GAME_STATE_KEY, mGameState);
        outState.putString(TEXT_VIEW_KEY, mTextView.getText().toString());
        Log.i("Suim",  "In onSaveInstanceState" + mTextView.getText().toString());
        // call superclass to save any view hierarchy
        // super.onSaveInstanceState(outState);
    }

    @Override public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("Suim",  "In onRestoreInstanceState" + savedInstanceState.getString(TEXT_VIEW_KEY));
        mTextView.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
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
