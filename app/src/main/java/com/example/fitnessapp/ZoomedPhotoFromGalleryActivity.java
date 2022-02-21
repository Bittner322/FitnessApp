package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class ZoomedPhotoFromGalleryActivity extends AppCompatActivity {

    ImageView zoomedPhotoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoomed_photo_from_gallery);

        zoomedPhotoImageView = findViewById(R.id.zoomedPhotoImageView);

        Bundle arguments = getIntent().getExtras();

        if(arguments != null) {
            byte[] byteArray = arguments.getByteArray("photo");
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            zoomedPhotoImageView.setImageBitmap(bmp);
        }
    }
}