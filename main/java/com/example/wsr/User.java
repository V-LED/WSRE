package com.example.wsr;

import android.util.Log;

/**
 * Created by Администратор on 02.11.2018.
 */

public class User {
    private  String name;
    private  String date;
    private  String phone;
    public User(String name, String date, String phone) {
        this.name = name;
        Log.d("User Name","name = " +name);
        this.date = date;
        Log.d("User Date", "date = " + date);
        this.phone = phone;
        Log.d("User Date", "date = " + phone);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getName() {
        Log.w("mad","mad" + name);
        return name;
    }
    public String getDate() {
        Log.w("mad", "mad" + date);
        return date;
    }
    public String getPhone() {
        Log.w("mad", "mad" + phone);
        return phone;
    }
}
