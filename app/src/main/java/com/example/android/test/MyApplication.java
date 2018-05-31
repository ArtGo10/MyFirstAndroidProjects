package com.example.android.test;

import android.app.Application;


public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        MyShareds.myInstance().setupShareds(MyApplication.this);
    }
}