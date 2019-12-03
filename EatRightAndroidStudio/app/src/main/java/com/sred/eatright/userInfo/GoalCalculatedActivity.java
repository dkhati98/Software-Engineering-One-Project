package com.sred.eatright.userInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sred.eatright.DatabaseHelper;
import com.sred.eatright.R;
import com.sred.eatright.userDiary.HomeActivity;

public class GoalCalculatedActivity extends AppCompatActivity{
    private double BMR;
    private double goalCalories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_calculated);
        final int _id = (Integer)getIntent().getExtras().get("id");

        //getting data from DB
        try {
            DatabaseHelper dbGetter = new DatabaseHelper(this);
            Profile profile = dbGetter.GetDB(_id);

            String userGender = profile.getUserGender();
            int userWeight = profile.getUserWeight();
            int userHeightft = profile.getUserHeightFeet();
            int userHeightin = profile.getUserHeightInches();
            int userAge = profile.getUserAge();
            String userActivityLevel = profile.getUserActivityLevel();
            String userFitnessGoal = profile.getUserFitnessGoal();

            setBMR(userGender, userWeight, userHeightft, userHeightin, userAge);
            setGoalCaloriesActivityLevel(userActivityLevel);
            setGoalCaloriesFitnessGoal(userFitnessGoal);



            String userGoalCalories = profile.getUserFitnessGoal();

            final TextView user_goal_calories = (TextView) findViewById(R.id.user_goal_calories);
            user_goal_calories.setText(userGoalCalories);

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        final Button next = (Button) findViewById(R.id.button_next);

        DatabaseHelper dbGetter = new DatabaseHelper( this);
        Profile profile = dbGetter.GetDB(_id);

        String usersName= profile.getUsersName();
        String userEmail= profile.getUserEmail();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert code to view calculated goal
                Intent moveToHome = new Intent(GoalCalculatedActivity.this, HomeActivity.class);
                moveToHome.putExtra("id",_id);
                startActivity(moveToHome);
            }
        });
    }

    //calculate the BMR
    private double setBMR(String gender, int weight, int heightft, int heightin, int age) {
        int height = heightft + heightin / 12;

        if(gender.equals("MALE" )|| gender.equals("PREFERNOTTOSAY"))
        {
            BMR = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
        }
        if (gender.equals("FEMALE"))
        {
            BMR = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
        }
        return BMR;
    }

    private void setGoalCaloriesActivityLevel(String activityLevel) {

        if(activityLevel.equals("SEDENTARY")) {
            goalCalories = BMR * 1.2;
        }
        else if(activityLevel.equals("SLIGHTLYACTIVE")) {
            goalCalories = BMR * 1.375;
        }
        else if(activityLevel.equals("MODERATELYACIVE")) {
            goalCalories = BMR * 1.55;
        }
        else if(activityLevel.equals("VERYACTIVE")) {
            goalCalories = BMR * 1.725;
        }
        else {
            goalCalories = BMR * 1.9;
        }
        goalCalories = (int)goalCalories;
    }


    private void setGoalCaloriesFitnessGoal(String fitnessGoal) {
        if(fitnessGoal.equals("GAIN")) {
            goalCalories = goalCalories + 500;
        }
        else if(fitnessGoal.equals("LOSE")) {
            goalCalories = goalCalories - 500;
        }
    }
}
