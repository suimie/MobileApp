package com.example.a1796138.practicedb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<User> userList;
    private int layout;

    public ListViewAdapter(Context context, int layout, ArrayList<User> userList){
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.userList = userList;
        this.layout = layout;

    }

    @Override
    public int getCount() {return userList.size();}

    @Override
    public User getItem(int position){
        return userList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null)
            convertView = inflater.inflate(layout, parent, false);
    //    convertView = inflater.inflate(layout, null);

        TextView lvetName = convertView.findViewById(R.id.lvetName);
        TextView lvetAddress = convertView.findViewById(R.id.lvetAddress);
        TextView lvetPhone = convertView.findViewById(R.id.lvetPhone);

        User user = userList.get(position);

        lvetName.setText(user.name);
        lvetAddress.setText(user.address);
        lvetPhone.setText(user.phone);


        return convertView;
    }
}
