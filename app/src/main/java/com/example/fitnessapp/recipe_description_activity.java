package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.nio.BufferUnderflowException;

public class recipe_description_activity extends AppCompatActivity {

    TextView eatNameTv;
    TextView kcalTv;
    TextView eatInfoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_description);

        eatNameTv = findViewById(R.id.eatNameTv);
        kcalTv = findViewById(R.id.kcalTv);
        eatInfoTv = findViewById(R.id.eatInfoTv);


    }
}