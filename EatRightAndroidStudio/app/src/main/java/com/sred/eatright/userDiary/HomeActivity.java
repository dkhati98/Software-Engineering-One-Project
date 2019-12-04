
package com.sred.eatright.userDiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sred.eatright.DatabaseHelper;
import com.sred.eatright.Main2Activity;
import com.sred.eatright.R;
import com.sred.eatright.userInfo.Profile;
import com.sred.eatright.userInfo.ProfileActivity;

public class HomeActivity extends AppCompatActivity {
    RecyclerView rv_lunch_log,rv_breakfast_log,rv_dinner_log,rv_snacks_log;
    LinearLayoutManager lm_lunch,lm_breakfast,lm_dinner,lm_snacks;
    FoodLogAdapter foodLogAdapter;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final int _id = (Integer) getIntent().getExtras().get("id");

        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        lm_lunch = new LinearLayoutManager(getApplicationContext());
        foodLogAdapter = new FoodLogAdapter(db.getFoodList(0,"Lunch"),getApplicationContext());
        rv_lunch_log = findViewById(R.id.rv_lunch);
        rv_lunch_log.setAdapter(foodLogAdapter);
        rv_lunch_log.setLayoutManager(lm_lunch);

        lm_breakfast = new LinearLayoutManager(getApplicationContext());
        foodLogAdapter = new FoodLogAdapter(db.getFoodList(0,"Breakfast"),getApplicationContext());
        rv_breakfast_log = findViewById(R.id.rv_breakfast);
        rv_breakfast_log.setAdapter(foodLogAdapter);
        rv_breakfast_log.setLayoutManager(lm_breakfast);


        lm_dinner = new LinearLayoutManager(getApplicationContext());
        foodLogAdapter = new FoodLogAdapter(db.getFoodList(0,"Dinner"),getApplicationContext());
        rv_dinner_log = findViewById(R.id.rv_dinner);
        rv_dinner_log.setAdapter(foodLogAdapter);
        rv_dinner_log.setLayoutManager(lm_dinner);

        lm_snacks = new LinearLayoutManager(getApplicationContext());
        foodLogAdapter = new FoodLogAdapter(db.getFoodList(0,"Snacks"),getApplicationContext());
        rv_snacks_log = findViewById(R.id.rv_snacks);
        rv_snacks_log.setAdapter(foodLogAdapter);
        rv_snacks_log.setLayoutManager(lm_snacks);



        final Button button_help = (Button) findViewById(R.id.button_help);
        final Button button_search = (Button) findViewById(R.id.button_search);
        final Button button_profile = (Button) findViewById(R.id.button_profile);
        final Button add_breakfast = (Button) findViewById(R.id.button_add_breakfast);
        final Button add_lunch = (Button) findViewById(R.id.button_add_lunch);
        final Button add_dinner = (Button) findViewById(R.id.button_add_dinner);
        final Button add_snacks = (Button) findViewById(R.id.button_add_snacks);
        final Button log_out = (Button) findViewById(R.id.button_log_out);

        final TextView calories_goal = (TextView) findViewById(R.id.calories_goal);
        final TextView calories_consumed = (TextView) findViewById(R.id.calories_consumed);
        final TextView calories_leftover = (TextView) findViewById(R.id.calories_leftover);

        db = new DatabaseHelper(this);
        Profile profile = db.GetDB(_id);
        int goalCalorie=0;
        try {
            goalCalorie=Integer.parseInt(profile.getUserGoalCalories());

        }catch (Exception e)
        {
            Log.d("errors",e.getMessage());
        }
        int calories_remaining;
        calories_remaining = goalCalorie-(db.getFoodCalories(_id));
        calories_goal.setText(Integer.toString(goalCalorie));
        calories_consumed.setText(Integer.toString(db.getFoodCalories(_id)));
        calories_leftover.setText(String.valueOf(calories_remaining));


//        int calorieConsumed = Integer.parseInt(profile.getUserGoalCalories());
//        final TextView goal_consumed = (android.widget.TextView) findViewById(R.id.goal_consumed);
//        goal_consumed.setText(Integer.toString(calorieConsumed));

        //search and add to breakfast button
        add_breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add_breakfast.setVisibility(View.INVISIBLE);
                String mealType = "Breakfast";
                callFragment(_id,mealType);
            }
        });

        //search and add to lunch button
        add_lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mealType = "Lunch";
                callFragment(_id,mealType);
            }
        });

        //search and add to dinner button
        add_dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mealType = "Dinner";
                callFragment(_id,mealType);

            }
        });

        //search and add to snacks button
        add_snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mealType = "Snacks";
                callFragment(_id,mealType);

            }
        });

        //help button
        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelp = new Intent(HomeActivity.this, HelpActivity.class);
                moveToHelp.putExtra("id",_id);
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

        //search screen button
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFragment(_id,null);
            }
        });

        log_out.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveToLogin = new Intent(HomeActivity.this, Main2Activity.class);
                startActivity(moveToLogin);
            }
        }));
    }
    private void callFragment(int _id, String mealType)
    {
        Bundle bundle = new Bundle();
        bundle.putString("id",String.valueOf(_id));
        bundle.putString("mealType",String.valueOf(mealType));
        Search myfragent = new Search();
        myfragent.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, myfragent, myfragent.getClass().getSimpleName()).addToBackStack(null).commit();
    }

}

