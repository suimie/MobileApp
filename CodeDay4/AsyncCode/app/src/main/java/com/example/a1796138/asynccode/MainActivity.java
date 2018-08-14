package com.example.a1796138.asynccode;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;


class Student{
    String id;
    String name;
    String email;

    String getInfo(){
        return "[" + id + "]" + name + ":" + email;
    }
}

public class MainActivity extends AppCompatActivity {
    boolean isIDOnly = false;
    ArrayList userList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getData(View view){
        Toast.makeText(this, "Button Created", Toast.LENGTH_LONG).show();
        URL apiUrl;
        try {
            apiUrl = new URL("https://jsonplaceholder.typicode.com/users");
            new FetchDataFromApi().execute(apiUrl);
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }
    }

    public void pickUser(View view){
        Random rand = new Random();

        int  n = rand.nextInt(10);

        Student student = (Student)userList.get(n);
        TextView tvResult = findViewById(R.id.tvResult);

        if(isIDOnly){
            tvResult.setText("ID : " + student.id);
        }else {
            tvResult.setText(student.getInfo());
        }

        /*
        URL apiUrl;
        try {
            apiUrl = new URL("https://jsonplaceholder.typicode.com/users/" + n);
            new FetchDataFromApi().execute(apiUrl);
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }
        */
    }

    public void pickUserOnlyId(View view){
        isIDOnly = true;

        pickUser(view);
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

            if(isIDOnly){
                try {
                    JSONObject json = new JSONObject(s);
                    String id = json.getString("id");
                    tvResult.setText("Id : " + id);
                }catch (JSONException e) {
                    e.printStackTrace();
                }
            }else {
                tvResult.setText(s);
            }

            isIDOnly = false;

            try {
//                String str = s.replace("\n", "");
//                str = str.replace("[", "");
//                str = str.replace("]", "");
//                JSONObject  json = new JSONObject(str);
//                json.getJ

                JSONArray jArray = new JSONArray(s);

                tvResult.setText("");
                for(int i=0; i<jArray.length();i++){
                    JSONObject user = jArray.getJSONObject(i);
                    Student student = new Student();

                    student.id = user.getString("id");
                    student.name = user.getString("name");
                    student.email = user.getString("email");
                    userList.add(student);
                    tvResult.append(student.getInfo());
                    tvResult.append("\n\n");
                }

                //tvResult.setText(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
