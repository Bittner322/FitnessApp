package com.example.fitnessapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AllExercisesListView extends ArrayAdapter<String> {

    final Activity context;
    final String[] exerciseTitle;
    final String[] exerciseInfo;
    final int[] img;

    public AllExercisesListView(Activity context, String[] exerciseTitle, String[] exerciseInfo, int[] img) {

        super(context, R.layout.all_exercises_list_view_layout, exerciseTitle);

        this.context = context;
        this.exerciseTitle = exerciseTitle;
        this.exerciseInfo = exerciseInfo;
        this.img = img;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.all_exercises_list_view_layout, null, true);

        TextView allExercisesListViewTitle = (TextView) rowView.findViewById(R.id.allExercisesListViewTitle);
        ImageView allExercisesListViewImage = (ImageView) rowView.findViewById(R.id.allExercisesListViewImage);
        TextView allExercisesListViewInfo = (TextView) rowView.findViewById(R.id.allExercisesListViewInfo);

        allExercisesListViewTitle.setText(exerciseTitle[position]);
        allExercisesListViewImage.setImageResource(img[position]);
        allExercisesListViewInfo.setText(exerciseInfo[position]);

        return rowView;
    }
}
