package com.example.rob.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tables(1);

        int max = 19;
        int currentProgress = 0;

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max);
        seekBar.setProgress(currentProgress);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Seekbar Progress", String.valueOf(progress + 1));
                tables(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void tables(int number) {
        int n = number;

        ArrayList<Integer> myTables = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int result = n * i;
            Log.i("Table", String.valueOf(result));

            myTables.add(result);
        }

        listView = findViewById(R.id.listView);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, myTables);
        listView.setAdapter(arrayAdapter);
    }
}