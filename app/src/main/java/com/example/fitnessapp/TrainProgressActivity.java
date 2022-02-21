package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TrainProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_progress);
    }

    public void fromTrainProgressToMyBody(View view) {
        Intent fromTrainProgressToMyBody = new Intent(TrainProgressActivity.this, BodyActivity.class);
        startActivity(fromTrainProgressToMyBody);
    }
}