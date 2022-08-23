package com.example.wegojim.ui;

import com.example.wegojim.R;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CreateWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        List<String> list = new ArrayList<String>();
        list.add("Bench Press");
        list.add("Deadlift");
        list.add("Barbell Squat");
        list.add("Pull Ups");
        list.add("Dumbbell Shoulder Press");
        list.add("Wide Grip Lat Pulldown");
        list.add("Shoulder Fly Superset");
        list.add("Preacher Curls");
        list.add("Cross Body Cable Extensions");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.textview, list);
        ListView exerciseList = (ListView) findViewById(R.id.createWorkoutList);
        exerciseList.setAdapter(itemsAdapter);


    }
}