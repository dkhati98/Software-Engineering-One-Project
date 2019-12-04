package com.sred.eatright.userDiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sred.eatright.DatabaseHelper;
import com.sred.eatright.R;

public class CustomFoodActivity extends AppCompatActivity {
    DatabaseHelper db = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_food);
        final int _id = (Integer)getIntent().getExtras().get("id");
        final String mealType = String.valueOf(getIntent().getExtras().get("mealType"));
        final Button button_help = (Button) findViewById(R.id.button_help);
//        final Button button_home = (Button) findViewById(R.id.button_home);
//        final Button button_profile = (Button) findViewById(R.id.button_profile);
//        final Button button_search = (Button) findViewById(R.id.button_search);
        final Button cancel_creation = (Button) findViewById(R.id.button_cancel);
        final Button save_creation = (Button) findViewById(R.id.button_save);
        final EditText custom_name = (EditText) findViewById(R.id.custom_food_name);
        final EditText custom_calorie = (EditText) findViewById(R.id.custom_food_calories);
        final EditText custom_protein = (EditText) findViewById(R.id.custom_food_protein);
        final EditText custom_fat = (EditText) findViewById(R.id.custom_food_fat);
        final EditText custom_carbs = (EditText) findViewById(R.id.custom_food_carbs);
        Log.d("lev2","I am here");
        try {
            Log.d("lev1","I am here");
            Intent intent = getIntent();

            final String foodName = intent.getStringExtra("foodName");
            final String foodBrand = intent.getStringExtra("foodBrand");
            final Double foodCal = intent.getDoubleExtra("foodCalorie",0.0);
            final String foodCalorie = intent.getStringExtra("foodCalorie");
            Log.d("dipin1","I am here");
            Log.d("dipin",intent.getStringExtra("foodName"));


            Log.d("dipin",foodBrand+foodName+foodCalorie+"nothing came up");
            custom_name.setText(foodName);
            custom_calorie.setText(String.valueOf(foodCal));

        }catch (Exception e)
        {
            Log.d("errors",e.getMessage());
        }

        //help button
        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelp = new Intent(CustomFoodActivity.this, HelpActivity.class);
                startActivity(moveToHelp);
            }
        });

        //cancel
        cancel_creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToSearch = new Intent(CustomFoodActivity.this, Search.class);
                moveToSearch.putExtra("id",_id);
                startActivity(moveToSearch);
            }
        });

        //save food to DB
        save_creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = custom_name.getText().toString().trim();
                final int calories = Integer.parseInt(custom_calorie.getText().toString().trim());
                final int protein = Integer.parseInt(custom_protein.getText().toString().trim());
                final int fat = Integer.parseInt(custom_fat.getText().toString().trim());
                final int carbohydrate = Integer.parseInt(custom_carbs.getText().toString().trim());

                //Insert code to save custom created food to DB, then add to home screen
                Log.d("FoodHere",name + " " + calories + " "+ protein+" "+fat+" "+carbohydrate);

                int foodID = db.addFood(name,calories,carbohydrate, protein, fat);

                db.addFoodMeal(_id, foodID,mealType,calories);
                Log.d("FoodID", foodID+" "+mealType+" "+calories);
                Intent moveToHome = new Intent(CustomFoodActivity.this, HomeActivity.class);
                moveToHome.putExtra("id",_id);
                startActivity(moveToHome);
            }
        });


    }
}
//        //search button
//        button_search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent moveToCustomFood = new Intent(CustomFoodActivity.this, SearchActivity.class);
//                startActivity(moveToCustomFood);
//            }
//        });
//
//        //home screen button
//        button_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent moveToHome = new Intent(CustomFoodActivity.this, HomeActivity.class);
//                startActivity(moveToHome);
//            }
//        });
//
//        //profile button
//        button_profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent moveToProfile = new Intent(CustomFoodActivity.this, ProfileActivity.class);
//                startActivity(moveToProfile);
//            }
//        });