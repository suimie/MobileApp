package com.example.a1796138.recyclerviewexample;

public class User {
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
