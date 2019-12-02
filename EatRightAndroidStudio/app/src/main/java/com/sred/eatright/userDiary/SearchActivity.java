package com.sred.eatright.userDiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sred.eatright.R;
import com.sred.eatright.userInfo.ProfileActivity;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final Button button_help = (Button) findViewById(R.id.button_help);
        final Button button_home = (Button) findViewById(R.id.button_home);
        final Button button_profile = (Button) findViewById(R.id.button_profile);
        final EditText search_bar = (EditText) findViewById(R.id.search_bar);
        final Button scanner = (Button) findViewById(R.id.scan_food);
        final Button create_food = (Button) findViewById(R.id.create_food);

        //Insert code for search bar (EditText name search_bar)

        //Insert code for scanner (Button name scanner)

        //help button
        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelp = new Intent(SearchActivity.this, HelpActivity.class);
                startActivity(moveToHelp);
            }
        });

        //create food button
        create_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToCustomFood = new Intent(SearchActivity.this, CustomFoodActivity.class);
                startActivity(moveToCustomFood);
            }
        });

        //home screen button
        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHome = new Intent(SearchActivity.this, HomeActivity.class);
                startActivity(moveToHome);
            }
        });

        //profile button
        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToProfile = new Intent(SearchActivity.this, ProfileActivity.class);
                startActivity(moveToProfile);
            }
        });

    }
}
