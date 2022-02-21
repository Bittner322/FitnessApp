package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import java.io.ByteArrayOutputStream;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }

    public void onGalleryPhotoClick(View view) {
        Intent zoomPhoto = new Intent(GalleryActivity.this, ZoomedPhotoFromGalleryActivity.class);

        Bitmap bmp = ((BitmapDrawable)view.getBackground()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        zoomPhoto.putExtra("photo", byteArray);

        startActivity(zoomPhoto);
    }
}