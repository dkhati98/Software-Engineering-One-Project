package com.sred.eatright.userDiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sred.eatright.R;
import com.sred.eatright.userInfo.ProfileActivity;

public class CustomFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_food);

        final Button button_help = (Button) findViewById(R.id.button_help);
        final Button cancel_creation = (Button) findViewById(R.id.button_cancel);
        final Button save_creation = (Button) findViewById(R.id.button_save);
        final EditText custom_name = (EditText) findViewById(R.id.custom_food_name);
        final EditText custom_calorie = (EditText) findViewById(R.id.custom_food_calories);
        final EditText custom_protein = (EditText) findViewById(R.id.custom_food_protein);
        final EditText custom_fat = (EditText) findViewById(R.id.custom_food_fat);
        final EditText custom_carbs = (EditText) findViewById(R.id.custom_food_carbs);

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
                Intent moveToSearch = new Intent(CustomFoodActivity.this, SearchActivity.class);
                startActivity(moveToSearch);
            }
        });

        //save food to DB
        save_creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert code to save custom created food to DB, then add to home screen
                Intent moveToHome = new Intent(CustomFoodActivity.this, HomeActivity.class);
                startActivity(moveToHome);
            }
        });


    }
}
