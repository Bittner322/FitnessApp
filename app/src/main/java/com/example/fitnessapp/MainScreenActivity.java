package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void recipesTvClick(View view) {
        Intent toRecipesActivityIntent = new Intent(MainScreenActivity.this, RecipesActivity.class);
        startActivity(toRecipesActivityIntent);
    }

    public void seeAllExercisesClick(View view) {
        Intent toAllExercisesIntent = new Intent(MainScreenActivity.this, allExercisesActivity.class);
        startActivity(toAllExercisesIntent);
    }

    public void backClickFromMainScreen(View view) {
        Intent backFromMainScreenIntent = new Intent(MainScreenActivity.this, SignInActivity.class);
        startActivity(backFromMainScreenIntent);
        finish();
    }

    public void fromMainScreenToMyBody(View view) {
        Intent fromMainScreenToMyBody = new Intent(MainScreenActivity.this, BodyActivity.class);
        startActivity(fromMainScreenToMyBody);
    }

    public void lastExercisePlankClick(View view) {
        Intent fromMainScreenToPlankIntent = new Intent(MainScreenActivity.this, PlankTimerActivity.class);
        startActivity(fromMainScreenToPlankIntent);
    }
}