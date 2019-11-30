package com.sred.eatright;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class GetGoal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getgoal);

        final RadioGroup radioGoal = (RadioGroup) findViewById(R.id.radioGoals);
        final RadioButton goal;
        final Button next = (Button) findViewById(R.id.button_next);

        final int selectedGoal = radioGoal.getCheckedRadioButtonId();
        goal = (RadioButton)findViewById(selectedGoal);

        final String realGoal = goal.getText().toString().trim();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (data > 0) {
//                    //Insert code to save to DB: goal
//                    if (realGoal == "Lose Weight") {
//                        Intent moveToLoseweight = new Intent(GetGoal.this, LoseWeight.class);
//                        startActivity(moveToLoseweight);
//                    } else if (realGoal == "Gain Weight") {
//                        Intent moveToGainweight = new Intent(GetGoal.this, GainWeight.class);
//                        startActivity(moveToGainweight);
//                    } else if (realGoal == "Maintain Weight") {
//                        Intent moveToMaintain = new Intent(GetGoal.this, ActivityLevel.class);
//                        startActivity(moveToMaintain);
//                    } else {
//                        Toast.makeText(GetGoal.this, "Select a goal before continuing", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else {
//                    Toast.makeText(GetGoal.this, "Unable to connect to Internet", Toast.LENGTH_SHORT).show();
//                }

            }
        });
    }
}
