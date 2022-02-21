package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RecipesActivity extends AppCompatActivity {

    ListView recipesLv;

    final String[] recipeTitlesBalanced = {"Chicken", "Beef", "Pork"};
    final String[] kcalsBalanced = {"1337", "322", "5427"};
    final String[] recipeInfosBalanced = {"290g protein • 325g fat • 746g carbs", "32g protein • 322g fat • 766g carbs", "519g protein • 661g fat • 1095g carbs"};
    final int[] imgBalanced = {R.drawable.testeat, R.drawable.test_eat_second, R.drawable.test_eat_third};

    final String[] recipeTitlesFiber = {"Muffins with carrot", "Milky porridge with cranberries", "Creamy pasta with zucchini"};
    final String[] kcalsFiber = {"2345", "7634", "562"};
    final String[] recipeInfosFiber = {"902g protein • 334g fat • 754g carbs", "550g protein • 225g fat • 767g carbs", "290g protein • 325g fat • 746g carbs"};
    final int[] imgFiber = {R.drawable.img_fiber_carrot, R.drawable.img_fiber_milky, R.drawable.img_fiber_cream};

    final String[] recipeTitlesProtein = {"Brownie oatmeal", "Protein cake", "Protein roll"};
    final String[] kcalsProtein = {"9902", "8324", "6223"};
    final String[] recipeInfosProtein = {"1000g protein • 125g fat • 666g carbs", "914g protein • 265g fat • 468g carbs", "290g protein • 325g fat • 746g carbs"};
    final int[] imgProtein = {R.drawable.img_brownie_protein, R.drawable.img_cake_protein, R.drawable.img_roll_protein};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        recipesLv = findViewById(R.id.recipesLv);

        recipesLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent toRecipeDescriptionActivity = new Intent(RecipesActivity.this, recipe_description_activity.class);
                startActivity(toRecipeDescriptionActivity);
            }
        });
    }

    public void onBalancedClick(View view) {
        MyListView adapter = new MyListView(this, recipeTitlesBalanced, kcalsBalanced, recipeInfosBalanced, imgBalanced);
        recipesLv.setAdapter(adapter);
    }

    public void highFiberClick(View view) {
        MyListView adapter = new MyListView(this, recipeTitlesFiber, kcalsFiber, recipeInfosFiber, imgFiber);
        recipesLv.setAdapter(adapter);
    }

    public void highProteinClick(View view) {
        MyListView adapter = new MyListView(this, recipeTitlesProtein, kcalsProtein, recipeInfosProtein, imgProtein);
        recipesLv.setAdapter(adapter);
    }

    public void fromRecipesToMainScreen(View view) {
        Intent fromRecipesToMainScreenIntent = new Intent(RecipesActivity.this, MainScreenActivity.class);
        startActivity(fromRecipesToMainScreenIntent);
    }
}