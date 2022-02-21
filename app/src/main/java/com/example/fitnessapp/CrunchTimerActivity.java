package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CrunchTimerActivity extends AppCompatActivity {

    static int crunchProgress = 25;
    CountDownTimer countDownTimer;
    static int crunchTimerClicks = 0;
    ProgressBar crunchProgressBar;
    Button crunchStartFinishButton;
    TextView crunchTimerSecondsLeftTv;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crunch_timer);

        crunchProgressBar = findViewById(R.id.crunchProgressBar);
        crunchStartFinishButton = findViewById(R.id.crunchStartFinishButton);
        crunchTimerSecondsLeftTv = findViewById(R.id.crunchTimerSecondsLeftTv);

        crunchProgressBar.setMax(crunchProgress);
        crunchProgressBar.setProgress(crunchProgress);

        crunchTimerSecondsLeftTv.setText(String.valueOf(crunchProgress));
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(25000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                crunchProgress--;
                crunchProgressBar.setProgress(crunchProgress);
                crunchTimerSecondsLeftTv.setText(String.valueOf(crunchProgress));
            }

            @Override
            public void onFinish() {
                crunchProgress = 25;
                crunchTimerSecondsLeftTv.setText(String.valueOf(crunchProgress));
                crunchProgressBar.setProgress(crunchProgress);
            }
        }
        .start();
    }

    public void fromCrunchTimerToAllExercisesClick(View view) {
        Intent fromCrunchTimerToAllExercisesClickIntent = new Intent(CrunchTimerActivity.this, allExercisesActivity.class);
        startActivity(fromCrunchTimerToAllExercisesClickIntent);
    }

    public void crunchTimerClick(View view) {
        crunchTimerClicks++;
        if(crunchTimerClicks == 1) {
            startTimer();
            crunchStartFinishButton.setText("Finish");
        }
        else if(crunchTimerClicks == 2){
            countDownTimer.onFinish();
            crunchTimerClicks = 0;
            countDownTimer.cancel();
            crunchStartFinishButton.setText("Start");
            crunchTimerSecondsLeftTv.setText("");
            crunchTimerSecondsLeftTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.galochka, 0, 0, 0);
            handler.postDelayed(doneMessage, 500);
        }
    }

    Runnable doneMessage = new Runnable() {
        @Override
        public void run() {
            crunchTimerSecondsLeftTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            crunchTimerSecondsLeftTv.setText(String.valueOf(crunchProgress));
        }
    };
}