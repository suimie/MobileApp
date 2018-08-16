package com.example.a1796138.practicedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


class User{
    String name;
    String address;
    String phone;

    User(){

    }

    User(String n, String a, String p){
        name = n;
        address = a;
        phone = p;
    }

    String getInfo(){
        String info = "";
        info += "Name : " + name +  " | ";
        info += "Address : " + address + " | ";
        info += "Phone : " + phone + "\n";

        return info;
    }
}


public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etName, etAddress, etPhone;
    ListView listView;
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.tvInfo);
        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        listView = findViewById(R.id.lvUser);

        userList = new ArrayList<>();
        showAll(null);
    }

//    public void saveValuesToDB() {
//        MyDbHeloper dbHelper = new MyDbHeloper(this, "userdb", null, 1);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put("name", "john");
//        values.put("address", "Narnia");
//        values.put("phone", "514123456");
//
//        long rowId = db.insert("user", null, values);
//        //long rowId = db.insert("user", "phone", values);      // phone is a nullable column
//        Log.i("MYTAG", "Row number is " + rowId);
//    }

    public void saveInfo(View view){
        String name = etName.getText().toString();
        String address = etAddress.getText().toString();
        String phone = etPhone.getText().toString();

        if (name.length() > 0 && address.length() > 0 && phone.length() > 0) {
/*
            User user = new User(name, address, phone);
            userList.add(user);
*/
            MyDbHelper dbHelper = new MyDbHelper(this, "userdb", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("address", address);
            values.put("phone", phone);
            long rowId = db.insert("user", null, values);
            //long rowId = db.insert("user", "phone", values);      // phone is a nullable column
            Log.i("MYTAG", "Row number is " + rowId);

            etName.setText("");
            etAddress.setText("");
            etPhone.setText("");
            etPhone.clearFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }else{
            if(name.length() <= 0)
                etName.requestFocus();
            else if(address.length() <= 0)
                etAddress.requestFocus();
            else
                etPhone.requestFocus();
        }
    }

    public void showAll(View view){
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

        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.name_list, userList);
        listView.setAdapter(adapter);

    }
}
