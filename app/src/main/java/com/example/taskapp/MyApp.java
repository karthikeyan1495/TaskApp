package com.example.taskapp;

import android.app.Application;
import android.content.Context;

import com.example.taskapp.util.InternetChecker;

public class MyApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        MyApp.context = getApplicationContext();
        InternetChecker.getInstance().init();
    }

    public static Context getContext() {
        return MyApp.context;
    }

}
