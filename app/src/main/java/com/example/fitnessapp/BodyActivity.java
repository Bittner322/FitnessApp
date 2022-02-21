package com.example.fitnessapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BodyActivity extends AppCompatActivity {

    Button weightChangeButton;
    TextView weightTv;
    TextView heightTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        weightChangeButton = findViewById(R.id.weightChangeButton);
        weightTv = findViewById(R.id.weightTv);
        heightTv = findViewById(R.id.heightTv);
    }

    public void myBodyEditWeightOnClick(View view) {
        EditText dialogEditText = new EditText(this);
        dialogEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Изменение веса");
        alert.setMessage("Введите ваш вес на данный момент");

        alert.setView(dialogEditText);

        alert.setPositiveButton("Изменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String newWeight = dialogEditText.getText().toString();
                weightTv.setText(newWeight + " kg");
            }
        });

        alert.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        alert.show();
    }

    public void myBodyEditHeightClick(View view) {
        EditText dialogEditText = new EditText(this);
        dialogEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Изменение роста");
        alert.setMessage("Введите ваш рост на данный момент");

        alert.setView(dialogEditText);

        alert.setPositiveButton("Изменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String newWeight = dialogEditText.getText().toString();
                heightTv.setText(newWeight + " cm");
            }
        });

        alert.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        alert.show();
    }

    public void statisticsClick(View view) {
        Intent toStatisticsIntent = new Intent(BodyActivity.this, StatisticsActivity.class);
        startActivity(toStatisticsIntent);
    }

    public void fromBodyToMainScreenClick(View view) {
        Intent toMainScreenIntent = new Intent(BodyActivity.this, MainScreenActivity.class);
        startActivity(toMainScreenIntent);
    }

    public void fromMyBodyToTrainProgress(View view) {
        Intent toTrainProgress = new Intent(BodyActivity.this, TrainProgressActivity.class);
        startActivity(toTrainProgress);
    }

    public void fromMyBodyToGallery(View view) {
        Intent fromMyBodyToGallery = new Intent(BodyActivity.this, GalleryActivity.class);
        startActivity(fromMyBodyToGallery);
    }
}