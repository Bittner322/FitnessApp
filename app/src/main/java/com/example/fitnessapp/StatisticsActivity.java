package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
    }

    public void fromStatisticsToMyBody(View view) {
        Intent fromStatisticsToMyBody = new Intent(StatisticsActivity.this, BodyActivity.class);
        startActivity(fromStatisticsToMyBody);
    }
}