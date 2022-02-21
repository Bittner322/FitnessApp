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

public class PlankTimerActivity extends AppCompatActivity {

    static int progress = 60;
    ProgressBar plankProgressBar;
    CountDownTimer countDownTimer;
    TextView timerSecondsLeftTv;
    static int timerClicks = 0;
    Button plankStartFinishButton;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plank_timer);

        plankStartFinishButton = findViewById(R.id.pushUpsStartFinishButton);

        timerSecondsLeftTv = findViewById(R.id.timerSecondsLeftTv);
        timerSecondsLeftTv.setText(String.valueOf(progress));

        plankProgressBar = findViewById(R.id.plankProgressBar);
        plankProgressBar.setMax(progress);
        plankProgressBar.setProgress(progress);
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progress--;
                plankProgressBar.setProgress(progress);
                timerSecondsLeftTv.setText(String.valueOf(progress));
            }

            @Override
            public void onFinish() {
                progress = 60;
                timerSecondsLeftTv.setText(String.valueOf(progress));
                plankProgressBar.setProgress(progress);
            }
        }
        .start();
    }

    public void plankTimerClick(View view) {
        timerClicks++;
        if(timerClicks == 1) {
            startTimer();
            plankStartFinishButton.setText("Finish");
        }
        else if(timerClicks == 2){
            countDownTimer.onFinish();
            timerClicks = 0;
            countDownTimer.cancel();
            plankStartFinishButton.setText("Start");
            timerSecondsLeftTv.setText("");
            timerSecondsLeftTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.galochka, 0, 0, 0);
            handler.postDelayed(doneMessage, 500);
        }
    }

    Runnable doneMessage = new Runnable() {
        @Override
        public void run() {
            timerSecondsLeftTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            timerSecondsLeftTv.setText(String.valueOf(progress));
        }
    };

    public void fromPlankTimerToAllExercisesClick(View view) {
        Intent fromPlankTimerToAllExercisesClickIntent = new Intent(PlankTimerActivity.this, allExercisesActivity.class);
        startActivity(fromPlankTimerToAllExercisesClickIntent);
    }
}