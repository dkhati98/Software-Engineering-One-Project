package com.sred.eatright;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
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
                int _id = (Integer)getIntent().getExtras().get("id");
                long val = db.updateUserGoal(_id, realGoal);
                if (val > 0) {
//                        Intent moveToGoalsCalculated = new Intent(GetGoal.this, GoalsCalculated.class);
//                        startActivity(moveToGoalsCalculated);

                        Intent moveToProfile = new Intent(GetGoal.this, DisplayUserProfile.class);
                        startActivity(moveToProfile);
                        Toast.makeText(GetGoal.this, "Select a goal", Toast.LENGTH_SHORT).show();

                } else {
                        Toast.makeText(GetGoal.this, "Unable to connect to Internet", Toast.LENGTH_SHORT).show();
                    }


            }
        });
    }
}
