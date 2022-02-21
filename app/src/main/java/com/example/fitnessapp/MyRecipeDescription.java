package com.example.fitnessapp;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

public class MyRecipeDescription{
    final Activity context;
    final String[] recipeDescTitle;
    final String[] recipeDescKcals;
    final String[] recipeDescInfo;
    final int[] recipeDescImg;

    public MyRecipeDescription(Activity context, String[] recipeDescTitle, String[] recipeDescKcals, String[] recipeDescInfo, int[] recipeDescImg) {
        //super(context, R.layout.activity_recipe_description);

        this.context = context;
        this.recipeDescTitle = recipeDescTitle;
        this.recipeDescKcals = recipeDescKcals;
        this.recipeDescInfo = recipeDescInfo;
        this.recipeDescImg = recipeDescImg;
    }


}
