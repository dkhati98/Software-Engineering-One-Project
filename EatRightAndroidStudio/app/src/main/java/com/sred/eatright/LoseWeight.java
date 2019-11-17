package com.sred.eatright;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoseWeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_weight);

        final EditText goalWeight = (EditText)findViewById(R.id.goal_weight);
        final RadioGroup radioLossRate = (RadioGroup)findViewById(R.id.radioWeightLossRate);
        final RadioButton lossGoal;
        final Button next = (Button) findViewById(R.id.button_next);

        int selectedLossGoal = radioLossRate.getCheckedRadioButtonId();
        lossGoal = (RadioButton) findViewById(selectedLossGoal);

        final String lossgoal = lossGoal.getText().toString().trim();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data > 0) {
                    //insert code to save to DB: goal weight, loss rate
                    if (datasuccesfullySavedToDB) {
                        Intent moveToActivityLevel = new Intent(LoseWeight.this, ActivityLevel.class);
                        startActivity(moveToActivityLevel);
                    } else {
                        Toast.makeText(LoseWeight.this, "Unable to access Internet", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoseWeight.this, "Please fill in the blanks", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
