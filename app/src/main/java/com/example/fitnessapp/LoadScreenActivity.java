package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class LoadScreenActivity extends AppCompatActivity {

    TextView loadScreenTvSuperFit;

    Animation anim;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);

        anim = AnimationUtils.loadAnimation(this, R.anim.tv_animation);
        loadScreenTvSuperFit = findViewById(R.id.loadScreenTvSuperFit);

        loadScreenTvSuperFit.startAnimation(anim);
        handler.postDelayed(finish_load, 3000);
    }

    Runnable finish_load = new Runnable() {
        @Override
        public void run() {
            Intent finish_load_activity = new Intent(LoadScreenActivity.this, SignInActivity.class);
            startActivity(finish_load_activity);
            finish();
        }
    };
}