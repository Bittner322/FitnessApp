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

public class SquatsTimerActivity extends AppCompatActivity {

    static int squatsProgress = 40;
    CountDownTimer countDownTimer;
    static int squatsTimerClicks = 0;
    ProgressBar squatsProgressBar;
    Button squatsStartFinishButton;
    TextView squatsTimerSecondsLeftTv;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squats_timer);

        squatsProgressBar = findViewById(R.id.runningProgressBar);
        squatsStartFinishButton = findViewById(R.id.runningStartFinishButton);
        squatsTimerSecondsLeftTv = findViewById(R.id.runningTimerSecondsLeftTv);

        squatsProgressBar.setMax(squatsProgress);
        squatsProgressBar.setProgress(squatsProgress);
        squatsTimerSecondsLeftTv.setText(String.valueOf(squatsProgress));
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(40000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                squatsProgress--;
                squatsProgressBar.setProgress(squatsProgress);
                squatsTimerSecondsLeftTv.setText(String.valueOf(squatsProgress));
            }

            @Override
            public void onFinish() {
                squatsProgress = 40;
                squatsTimerSecondsLeftTv.setText(String.valueOf(squatsProgress));
                squatsProgressBar.setProgress(squatsProgress);
            }
        }
        .start();
    }

    public void fromSquatsTimerToAllExercisesClick(View view) {
        Intent fromSquatsTimerToAllExercisesClickIntent = new Intent(SquatsTimerActivity.this, allExercisesActivity.class);
        startActivity(fromSquatsTimerToAllExercisesClickIntent);
    }

    public void squatsTimerClick(View view) {
        squatsTimerClicks++;
        if(squatsTimerClicks == 1) {
            startTimer();
            squatsStartFinishButton.setText("Finish");
        }
        else if(squatsTimerClicks == 2){
            countDownTimer.onFinish();
            squatsTimerClicks = 0;
            countDownTimer.cancel();
            squatsStartFinishButton.setText("Start");
            squatsTimerSecondsLeftTv.setText("");
            squatsTimerSecondsLeftTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.galochka, 0, 0, 0);
            handler.postDelayed(doneMessage, 500);
        }
    }

    Runnable doneMessage = new Runnable() {
        @Override
        public void run() {
            squatsTimerSecondsLeftTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            squatsTimerSecondsLeftTv.setText(String.valueOf(squatsProgress));
        }
    };
}