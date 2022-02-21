package com.example.fitnessapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyListView extends ArrayAdapter<String> {

    final Activity context;
    final String[] recipeTitle;
    final String[] kcals;
    final String[] recipeInfo;
    final int[] img;

    public MyListView(Activity context, String[] recipeTitle, String[] kcals, String[] recipeInfo, int[] img) {

        super(context, R.layout.mylist, recipeTitle);

        this.context = context;
        this.kcals = kcals;
        this.recipeTitle = recipeTitle;
        this.recipeInfo = recipeInfo;
        this.img = img;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);

        TextView eatLabelTv = (TextView) rowView.findViewById(R.id.eatLabelTv);
        ImageView eatImage = (ImageView) rowView.findViewById(R.id.eatImage);
        TextView kcalsTv = (TextView) rowView.findViewById(R.id.kcalsTv);
        TextView eatInfoTv = (TextView) rowView.findViewById(R.id.eatInfoTv);

        eatLabelTv.setText(recipeTitle[position]);
        eatImage.setImageResource(img[position]);
        kcalsTv.setText(kcals[position]);
        eatInfoTv.setText(recipeInfo[position]);

        return rowView;
    }
}
