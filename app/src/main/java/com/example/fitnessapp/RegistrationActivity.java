package com.example.fitnessapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText nameEt;
    EditText emailEt;
    EditText codeEt;
    EditText codeRepeatEt;
    Button registrationSignUpButton;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nameEt = findViewById(R.id.registrationUserNameEt);
        emailEt = findViewById(R.id.registrationEmailEt);
        codeEt = findViewById(R.id.registrationCodeEt);
        codeRepeatEt = findViewById(R.id.registrationCodeRepeatEt);
        registrationSignUpButton = findViewById(R.id.registrationSignUpButton);

        builder = new AlertDialog.Builder(this);
    }

    public void signUpClick(View view) {
        if(nameEt.getText().length() != 0 && emailEt.getText().length() != 0 && emailEt.getText().toString().contains("@") && codeEt.getText().length() != 0 && codeRepeatEt.getText().length() != 0
        && codeEt.getText().toString().equals(codeRepeatEt.getText().toString()) && !codeEt.getText().toString().contains("0")) {
            Intent toMainScreenIntent = new Intent(RegistrationActivity.this, MainScreenActivity.class);
            startActivity(toMainScreenIntent);
        }
        else {
            builder.setTitle("Ошибка");
            builder.setMessage("Вы неправильно ввели данные!!!");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.create();
            builder.show();
        }
    }

    public void onSignInClickFromRegistration(View view) {
        Intent toSignInIntent = new Intent(RegistrationActivity.this, SignInActivity.class);
        startActivity(toSignInIntent);
    }
}