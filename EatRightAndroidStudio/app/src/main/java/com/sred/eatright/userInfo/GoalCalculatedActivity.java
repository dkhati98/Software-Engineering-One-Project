package com.sred.eatright.userInfo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
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
            int userWeight = Integer.parseInt(profile.getUserWeight());
            int userHeightft = Integer.parseInt(profile.getUserHeightFeet());
            int userHeightin = Integer.parseInt(profile.getUserHeightInches());
            int userAge = Integer.parseInt(profile.getUserAge());
            Log.d("userinfo",userGender + " +" +  userHeightft+ " " + userHeightin + " " + userWeight);
            String userActivityLevel = profile.getUserActivityLevel();
            String userFitnessGoal = profile.getUserFitnessGoal();
//            userGender + " +" +  userHeightft+ " " + userHeightin + " " + userWeight
           // calculate goalCalories
            setBMR(userGender, userWeight, userHeightft, userHeightin, userAge);
            setGoalCaloriesActivityLevel(userActivityLevel);
            setGoalCaloriesFitnessGoal(userFitnessGoal);
            //store goalCalories into DB
            dbGetter.updateUserGoalCalories(_id, goalCalories);
            Log.d("userinfo", BMR +" ");
            final TextView user_goal_calories = (TextView) findViewById(R.id.user_goal_calories);
            String _goalCalories = Double.toString(goalCalories);
            user_goal_calories.setText(_goalCalories);

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

        if(gender.equals("Male" )|| gender.equals("Prefer not to say"))
        {
            BMR = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
        }
        if (gender.equals("Female"))
        {
            BMR = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
        }
        return BMR;
    }

    private void setGoalCaloriesActivityLevel(String activityLevel) {

        if(activityLevel.equals("Not very active (0 to 6000 steps/day)")) {
            goalCalories = BMR * 1.2;
        }
        else if(activityLevel.equals("Slightly active (6000 to 8000 steps/day)")) {
            goalCalories = BMR * 1.375;
        }
        else if(activityLevel.equals("Active (8000 to 10000 steps/day)")) {
            goalCalories = BMR * 1.55;
        }
        else if(activityLevel.equals("Very active (10000 or more steps/day)")) {
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