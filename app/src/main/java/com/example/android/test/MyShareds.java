package com.example.android.test;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;


public class MyShareds {

    private static final String time = "time";

    private static MyShareds myShareds;

    private SharedPreferences preferences;
    private static SharedPreferences.Editor editor;


    public static MyShareds myInstance() {
        if (myShareds == null) {
            myShareds = new MyShareds();
        }
        return myShareds;
    }

    public void setupShareds(Context context) {
        preferences = context.getSharedPreferences("Shareds", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public <T> void setList(List<T> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        set(time, json);
    }

    private static void set(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public ArrayList<String> getMyData() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        if (preferences.getString(time, "").length() != 0) {
            String strings = preferences.getString(time, "");
            return gson.fromJson(strings, ArrayList.class);
        } else {
            return new ArrayList<>();
        }
    }

}