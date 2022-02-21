package com.example.fitnessapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    EditText signInEditText;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signInEditText = findViewById(R.id.signInEditText);
        builder = new AlertDialog.Builder(this);
    }

    public void onSignInFromSignIn(View view) {
        if(signInEditText.getText().length() != 0) {
            Intent toCodeIntent = new Intent(SignInActivity.this, UserCodeActivity.class);
            startActivity(toCodeIntent);
        }
        else {
            builder.setTitle("Ошибка");
            builder.setMessage("Вы неправильно ввели ник!!!");
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

    public void signUpClickFromSignInActivity(View view) {
        Intent toRegisterIntent = new Intent(SignInActivity.this, RegistrationActivity.class);
        startActivity(toRegisterIntent);
    }
}