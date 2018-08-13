package com.example.a1796138.asynccode;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getData(View view){
        Toast.makeText(this, "Button Created", Toast.LENGTH_LONG).show();
        URL apiUrl;
        try {
            apiUrl = new URL("https://jsonplaceholder.typicode.com/todos/1");
            new FetchDataFromApi().execute(apiUrl);
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }
    }

    public class FetchDataFromApi extends AsyncTask<URL, Void, String>{

        @Override
        protected String doInBackground(URL... urls) {
            URL myUrl = urls[0];
            String response = "";
            try {
                response = NetworkUtility.getResponseFromHttpUrl(myUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            TextView tvResult = findViewById(R.id.tvResult);
            TextView tvId = findViewById(R.id.tvId);
            TextView tvTitile = findViewById(R.id.tvTitle);

            try {
                JSONObject  json = new JSONObject(s);
                tvResult.setText(s);
                tvId.setText(json.getString("id"));
                tvTitile.setText(json.getString("title"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
