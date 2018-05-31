package com.example.android.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date currentTime = Calendar.getInstance().getTime();

        ArrayList<String> timeList = MyShareds.myInstance().getMyData();

        final TextView textViewCurrentTime = findViewById(R.id.CurrentTime);
        final TextView textViewLatestTime = findViewById(R.id.LatestTime);
        final Button buttonHistory = findViewById(R.id.history);
        if (timeList.size() > 1) {
            textViewCurrentTime.setText(String.valueOf(currentTime.getTime()));
            textViewLatestTime.setText(timeList.get(0));
        } else {
            textViewCurrentTime.setText(String.valueOf(currentTime.getTime()));
        }


        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
    }

}

