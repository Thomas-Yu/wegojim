package com.example.wegojim.ui;

import com.example.wegojim.R;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AddWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);


        List<String> list = new ArrayList<String>();
        list.add("Day 1 Upper");
        list.add("Day 2 Lower");
        list.add("Day 3 Upper");
        list.add("Rest Day");
        list.add("Day 4 Lower");
        list.add("Day 5 Upper");
        list.add("Rest Day");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.textview, list);
        ListView exerciseList = (ListView) findViewById(R.id.addWorkoutList);
        exerciseList.setAdapter(itemsAdapter);


    }
}