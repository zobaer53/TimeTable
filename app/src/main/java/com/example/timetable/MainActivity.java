package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;public void rateTimeTable(int timeTableNumber){ArrayList<String>arrayList= new ArrayList<>();

    for(int i=1;i<=10;i++){
        arrayList.add(Integer.toString(timeTableNumber*i));
    }
    ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
    listView.setAdapter(adapter);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
         listView = findViewById(R.id.listView);

        seekBar.setMax(20);
        seekBar.setProgress(10);
rateTimeTable(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timeTableNumber;
                if(progress<min){
                      timeTableNumber=min;
                      seekBar.setProgress(min);

                }else {

                    timeTableNumber=progress;
                }
                    rateTimeTable(timeTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}