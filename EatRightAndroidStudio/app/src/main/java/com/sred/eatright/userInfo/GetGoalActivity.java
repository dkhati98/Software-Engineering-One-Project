
package com.sred.eatright.userInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sred.eatright.DatabaseHelper;
import com.sred.eatright.R;

public class GetGoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getgoal);
        final DatabaseHelper db;
        db = new DatabaseHelper(this);
        final RadioGroup radioGoal = (RadioGroup) findViewById(R.id.radioGoals);

        final Button next = (Button) findViewById(R.id.button_next);

        final int _id = (Integer)getIntent().getExtras().get("id");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RadioButton goal;
                final int selectedGoal = radioGoal.getCheckedRadioButtonId();
                goal = (RadioButton)findViewById(selectedGoal);
                final String realGoal = goal.getText().toString().trim();
                if (realGoal != null) {
                    Log.d("goalHere", realGoal+" ");
                    long val = db.updateUserFitnessGoal(_id, realGoal);
                    if (val > 0) {
//                        Intent moveToGoalsCalculated = new Intent(GetGoalActivity.this, GoalCalculatedActivity.class);
//                        startActivity(moveToGoalsCalculated);
                        Intent moveToActivityLevel = new Intent(GetGoalActivity.this, ActivityLevelActivity.class);
                        moveToActivityLevel.putExtra("id",_id);
                        startActivity(moveToActivityLevel);
                        Toast.makeText(GetGoalActivity.this, "Select your Activity Level", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(GetGoalActivity.this, "Unable to connect to Database.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(GetGoalActivity.this, "Please Select an Option.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
