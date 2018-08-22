package com.example.a1796138.listviewpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mStringArray[] = {"Jonh", "Tom", "Marie", "Foo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.single_list_item_1, mStringArray);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
