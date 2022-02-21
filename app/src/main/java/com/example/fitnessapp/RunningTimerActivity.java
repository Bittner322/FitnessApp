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

public class RunningTimerActivity extends AppCompatActivity {

    static int runningProgress = 1500;
    CountDownTimer countDownTimer;
    static int runningTimerClicks = 0;
    ProgressBar runningProgressBar;
    Button runningStartFinishButton;
    TextView runningTimerSecondsLeftTv;
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_timer);

        runningProgressBar = findViewById(R.id.runningProgressBar);
        runningStartFinishButton = findViewById(R.id.runningStartFinishButton);
        runningTimerSecondsLeftTv = findViewById(R.id.runningTimerSecondsLeftTv);

        runningProgressBar.setMax(runningProgress);
        runningProgressBar.setProgress(runningProgress);

        runningTimerSecondsLeftTv.setText(String.valueOf(runningProgress));
    }

    public void fromRunningTimerToAllExercisesClick(View view) {
        Intent fromRunningTimerToAllExercisesClickIntent = new Intent(RunningTimerActivity.this, allExercisesActivity.class);
        startActivity(fromRunningTimerToAllExercisesClickIntent);
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(15000000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                runningProgress -= 2;
                runningProgressBar.setProgress(runningProgress);
                runningTimerSecondsLeftTv.setText(String.valueOf(runningProgress));
            }

            @Override
            public void onFinish() {
                runningProgress = 1500;
                runningTimerSecondsLeftTv.setText(String.valueOf(runningProgress));
                runningProgressBar.setProgress(runningProgress);
            }
        }
        .start();
    }

    public void runningTimerClick(View view) {
        runningTimerClicks++;
        if(runningTimerClicks == 1) {
            startTimer();
            runningStartFinishButton.setText("Finish");
        }
        else if(runningTimerClicks == 2){
            countDownTimer.onFinish();
            runningTimerClicks = 0;
            countDownTimer.cancel();
            runningStartFinishButton.setText("Start");
            runningTimerSecondsLeftTv.setText("");
            runningTimerSecondsLeftTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.galochka, 0, 0, 0);
            handler.postDelayed(doneMessage, 500);
        }
    }

    Runnable doneMessage = new Runnable() {
        @Override
        public void run() {
            runningTimerSecondsLeftTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            runningTimerSecondsLeftTv.setText(String.valueOf(runningProgress));
        }
    };
}