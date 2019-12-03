package com.sred.eatright.userDiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sred.eatright.DatabaseHelper;
import com.sred.eatright.R;
import com.sred.eatright.userInfo.Profile;
import com.sred.eatright.userInfo.ProfileActivity;

public class HomeActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final int _id = (Integer) getIntent().getExtras().get("id");
        final Button button_help = (Button) findViewById(R.id.button_help);
        final Button button_search = (Button) findViewById(R.id.button_search);
        final Button button_profile = (Button) findViewById(R.id.button_profile);
        final Button add_breakfast = (Button) findViewById(R.id.button_add_breakfast);
        final Button add_lunch = (Button) findViewById(R.id.button_add_lunch);
        final Button add_dinner = (Button) findViewById(R.id.button_add_dinner);
        final Button add_snacks = (Button) findViewById(R.id.button_add_snacks);


        final TextView calories_goal = (TextView) findViewById(R.id.calories_goal);
        final TextView calories_consumed = (TextView) findViewById(R.id.calories_consumed);
        final TextView calories_leftover = (TextView) findViewById(R.id.calories_leftover);

        DatabaseHelper db = new DatabaseHelper(this);
        Profile profile = db.GetDB(_id);
        int goalCalorie = Integer.parseInt(profile.getUserGoalCalories());
        calories_goal.setText(Integer.toString(goalCalorie));





//        int calorieConsumed = Integer.parseInt(profile.getUserGoalCalories());
//        final TextView goal_consumed = (android.widget.TextView) findViewById(R.id.goal_consumed);
//        goal_consumed.setText(Integer.toString(calorieConsumed));

        //search and add to breakfast button
        add_breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add_breakfast.setVisibility(View.INVISIBLE);

                Search myfragent = new Search();

                getSupportFragmentManager().beginTransaction().replace(R.id.container, myfragent, myfragent.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });

        //search and add to lunch button
        add_lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search myfragent = new Search();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, myfragent, myfragent.getClass().getSimpleName()).addToBackStack(null).commit();

            }
        });

        //search and add to dinner button
        add_dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search myfragent = new Search();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, myfragent, myfragent.getClass().getSimpleName()).addToBackStack(null).commit();

            }
        });

        //search and add to snacks button
        add_snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search myfragent = new Search();

                getSupportFragmentManager().beginTransaction().replace(R.id.container, myfragent, myfragent.getClass().getSimpleName()).addToBackStack(null).commit();

            }
        });

        //help button
        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelp = new Intent(HomeActivity.this, HelpActivity.class);
                startActivity(moveToHelp);
            }
        });


        //profile button
        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToProfile = new Intent(HomeActivity.this, ProfileActivity.class);
                moveToProfile.putExtra("id", _id);
                startActivity(moveToProfile);
            }
        });
    }
}
