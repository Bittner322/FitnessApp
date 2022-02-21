package com.example.fitnessapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class UserCodeActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    LinearLayout layoutNumber1;
    LinearLayout layoutNumber2;
    LinearLayout layoutNumber3;
    LinearLayout layoutNumber4;
    LinearLayout layoutNumber5;
    LinearLayout layoutNumber6;
    LinearLayout layoutNumber7;
    LinearLayout layoutNumber8;
    LinearLayout layoutNumber9;

    Random random = new Random();

    Button[] buttons = new Button[9];
    LinearLayout[] layouts = new LinearLayout[9];

    static int clicks = 0;

    static String[] codeClicks = new String[4];

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_code);

        builder = new AlertDialog.Builder(this);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        layoutNumber1 = findViewById(R.id.layoutNumber1);
        layoutNumber2 = findViewById(R.id.layoutNumber2);
        layoutNumber3 = findViewById(R.id.layoutNumber3);
        layoutNumber4 = findViewById(R.id.layoutNumber4);
        layoutNumber5 = findViewById(R.id.layoutNumber5);
        layoutNumber6 = findViewById(R.id.layoutNumber6);
        layoutNumber7 = findViewById(R.id.layoutNumber7);
        layoutNumber8 = findViewById(R.id.layoutNumber8);
        layoutNumber9 = findViewById(R.id.layoutNumber9);

        buttons = new Button[] {button1, button2, button3, button4, button5, button6, button7, button8, button9};
        layouts = new LinearLayout[] {layoutNumber1, layoutNumber2, layoutNumber3, layoutNumber4, layoutNumber5, layoutNumber6, layoutNumber7, layoutNumber8, layoutNumber9};
    }


    //метод для считывания нажатий на кнопки кода, а также их перемешивание
    public void onCodeClick(View view) {

        Button buff = (Button)view;

        String buttonText = buff.getText().toString();

        codeClicks[clicks] = buttonText;


        if(clicks >= 3) {
            if(codeClicks[0].equals("4") && codeClicks[1].equals("4") && codeClicks[2].equals("4") && codeClicks[3].equals("4"))  {
                clicks = 0;
                Intent fromUserCodeToMainScreenIntent = new Intent(UserCodeActivity.this, MainScreenActivity.class);
                startActivity(fromUserCodeToMainScreenIntent);
                finish();
            }
            else {
                builder.setTitle("Ошибка");
                builder.setMessage("Неправильный пароль!");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        clicks = 0;
                    }
                });
                builder.create();
                builder.show();
            }
        }

        for(int i = 0; i < layouts.length; i++) {
            int randIndex = random.nextInt(9);

            Button buttonBuff = new Button(this);
            buttonBuff.setText(buttons[i].getText().toString());
            buttons[i].setText(buttons[randIndex].getText().toString());
            buttons[randIndex].setText(buttonBuff.getText().toString());


        }
        clicks++;
    }
}