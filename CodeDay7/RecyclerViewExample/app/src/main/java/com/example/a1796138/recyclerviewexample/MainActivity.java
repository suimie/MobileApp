package com.example.a1796138.recyclerviewexample;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        for(int i=0; i < 30; i++)
//            saveData();

        MyDbHelper dbHelper = new MyDbHelper(this, "userdb", null, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] columns = {"name", "address", "phone"};
        Cursor cursor = db.query("user", columns, null, null, null, null, null);

        cursor.moveToFirst();
        userList = new ArrayList<>();

        fetchDataFromDB();

        initRecyclerView();
    }

    public void initRecyclerView(){

        RecyclerView myRcView = findViewById(R.id.rc_view);
        UserAdapter userAdapter = new UserAdapter(userList);

        myRcView.setAdapter(userAdapter);
        LinearLayoutManager layoutMgr = new LinearLayoutManager(this);
        layoutMgr.setOrientation(LinearLayoutManager.HORIZONTAL);

        myRcView.setLayoutManager(layoutMgr);
    }

    public void saveData(){
        MyDbHelper dbHelper = new MyDbHelper(this, "userdb", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "Suim");
        values.put("address", "123 Street");
        values.put("phone", "123456");
        long rowId = db.insert("user", null, values);
        //long rowId = db.insert("user", "phone", values);      // phone is a nullable column

    }

    public void fetchDataFromDB(){
        MyDbHelper dbHelper = new MyDbHelper(this, "userdb", null, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] columns = {"name", "address", "phone"};

        Cursor cursor = db.query("user", columns, null, null, null, null, null);

        cursor.moveToFirst();

        userList.clear();

        do {
            User user = new User();
            user.name = cursor.getString(0);
            user.address  = cursor.getString(1);
            user.phone = cursor.getString(2);

            userList.add(user);
            //tvInfo.append(user.getInfo());
        }while(cursor.moveToNext() );

    }
}
