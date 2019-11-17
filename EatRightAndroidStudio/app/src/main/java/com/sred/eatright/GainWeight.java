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

public class GainWeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain_weight);

        final EditText goalWeight = (EditText)findViewById(R.id.goal_weight);
        final RadioGroup radioGainRate = (RadioGroup)findViewById(R.id.radioWeightGainRate);
        final RadioButton gainGoal;
        final Button next = (Button) findViewById(R.id.button_next);

        int selectedLossGoal = radioGainRate.getCheckedRadioButtonId();
        gainGoal = (RadioButton) findViewById(selectedLossGoal);

        final String gaingoal = gainGoal.getText().toString().trim();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data > 0) {
                    //insert code to save to DB: goal weight, loss rate
                    if (datasuccesfullySavedToDB) {
                        Intent moveToActivityLevel = new Intent(GainWeight.this, ActivityLevel.class);
                        startActivity(moveToActivityLevel);
                    } else {
                        Toast.makeText(GainWeight.this, "Unable to access Internet", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(GainWeight.this, "Please fill in the blanks", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
