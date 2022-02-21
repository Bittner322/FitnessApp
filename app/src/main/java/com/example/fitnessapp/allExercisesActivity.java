package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class allExercisesActivity extends AppCompatActivity {

    ListView allExercisesLv;

    final String[] exerciseTitles = {"Push-Ups", "Plank", "Squats", "Running", "Crunch"};
    final String[] exerciseInfos = {"Push-ups exercise the pectoral muscles, triceps, and anterior deltoids.",
    "The plank strengthens the abdominals, back and shoulders.",
    "Сonsidered a vital exercise for increasing the strength and size of the lower body.",
    "It develops endurance, strengthens the legs and the cardiovascular system.",
    "It involves the entire abs, but primarily it works the rectus abdominis muscle."};
    final int[] imgs = {R.drawable.push_ups_img, R.drawable.plank_img, R.drawable.squarts_image, R.drawable.running_image, R.drawable.crunch_image};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_exercises);

        allExercisesLv = findViewById(R.id.allExercisesLv);
        AllExercisesListView adapter = new AllExercisesListView(this, exerciseTitles, exerciseInfos, imgs);
        allExercisesLv.setAdapter(adapter);

        allExercisesLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        Intent pushUpsIntent = new Intent(allExercisesActivity.this, PushUpsTimerActivity.class);
                        startActivity(pushUpsIntent);
                        break;
                    case 1:
                        Intent plankIntent = new Intent(allExercisesActivity.this, PlankTimerActivity.class);
                        startActivity(plankIntent);
                        break;
                    case 2:
                        Intent squatsIntent = new Intent(allExercisesActivity.this, SquatsTimerActivity.class);
                        startActivity(squatsIntent);
                        break;
                    case 3:
                        Intent runningIntent = new Intent(allExercisesActivity.this, RunningTimerActivity.class);
                        startActivity(runningIntent);
                        break;
                    case 4:
                        Intent crunchIntent = new Intent(allExercisesActivity.this, CrunchTimerActivity.class);
                        startActivity(crunchIntent);
                        break;
                }
            }
        });
    }

    public void fromExercisesToMainScreen(View view) {
        Intent fromExercisesToMainScreenIntent = new Intent(allExercisesActivity.this, MainScreenActivity.class);
        startActivity(fromExercisesToMainScreenIntent);
    }
}