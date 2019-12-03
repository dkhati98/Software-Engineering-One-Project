package com.sred.eatright.userInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        final RadioButton goal;
        final Button next = (Button) findViewById(R.id.button_next);

        final int selectedGoal = radioGoal.getCheckedRadioButtonId();
        goal = (RadioButton)findViewById(selectedGoal);

        final String realGoal = goal.getText().toString().trim();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (realGoal != null) {
                    int _id = (Integer)getIntent().getExtras().get("id");
                    long val = db.updateUserFitnessGoal(_id, realGoal);
                    if (val > 0) {
//                        Intent moveToGoalsCalculated = new Intent(GetGoalActivity.this, GoalCalculatedActivity.class);
//                        startActivity(moveToGoalsCalculated);

                        Intent moveToGoalsCalculated = new Intent(GetGoalActivity.this, GoalCalculatedActivity.class);
                        moveToGoalsCalculated.putExtra("id",_id);
                        startActivity(moveToGoalsCalculated);

                        Toast.makeText(GetGoalActivity.this, "Select a goal", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(GetGoalActivity.this, "Unable to connect to Internet", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(GetGoalActivity.this, "Please Select an Option.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}