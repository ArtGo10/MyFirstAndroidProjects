package com.example.android.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ArrayList<String> timeList = MyShareds.myInstance().getMyData();

        final TextView textViewLatestTime = findViewById(R.id.history);

        for (int i = 0; i < timeList.size(); i++) {
            textViewLatestTime.append(timeList.get(i));
            textViewLatestTime.append("\n");
        }
    }
}