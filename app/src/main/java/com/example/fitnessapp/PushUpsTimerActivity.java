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

public class PushUpsTimerActivity extends AppCompatActivity {

    static int pushUpsProgress = 35;
    ProgressBar pushUpsProgressBar;
    TextView pushUpsTimerSecondsLeftTv;
    Button pushUpsStartFinishButton;
    static int pushUpsTimerClicks = 0;
    CountDownTimer countDownTimer;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_ups_timer);

        pushUpsProgressBar = findViewById(R.id.runningProgressBar);
        pushUpsTimerSecondsLeftTv = findViewById(R.id.pushUpsTimerSecondsLeftTv);
        pushUpsStartFinishButton = findViewById(R.id.pushUpsStartFinishButton);

        pushUpsProgressBar.setMax(pushUpsProgress);
        pushUpsProgressBar.setProgress(pushUpsProgress);
        pushUpsTimerSecondsLeftTv.setText(String.valueOf(pushUpsProgress));
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(35000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                pushUpsProgress--;
                pushUpsProgressBar.setProgress(pushUpsProgress);
                pushUpsTimerSecondsLeftTv.setText(String.valueOf(pushUpsProgress));
            }

            @Override
            public void onFinish() {
                pushUpsProgress = 35;
                pushUpsTimerSecondsLeftTv.setText(String.valueOf(pushUpsProgress));
                pushUpsProgressBar.setProgress(pushUpsProgress);
            }
        }
        .start();
    }

    public void pushUpsTimerClick(View view) {
        pushUpsTimerClicks++;
        if(pushUpsTimerClicks == 1) {
            startTimer();
            pushUpsStartFinishButton.setText("Finish");
        }
        else if(pushUpsTimerClicks == 2){
            countDownTimer.onFinish();
            pushUpsTimerClicks = 0;
            countDownTimer.cancel();
            pushUpsStartFinishButton.setText("Start");
            pushUpsTimerSecondsLeftTv.setText("");
            pushUpsTimerSecondsLeftTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.galochka, 0, 0, 0);
            handler.postDelayed(doneMessage, 500);
        }
    }

    Runnable doneMessage = new Runnable() {
        @Override
        public void run() {
            pushUpsTimerSecondsLeftTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            pushUpsTimerSecondsLeftTv.setText(String.valueOf(pushUpsProgress));
        }
    };

    public void fromPushUpsTimerToAllExercises(View view) {
        Intent fromPushUpsTimerToAllExercisesIntent =  new Intent(PushUpsTimerActivity.this, allExercisesActivity.class);
        startActivity(fromPushUpsTimerToAllExercisesIntent);
    }
}