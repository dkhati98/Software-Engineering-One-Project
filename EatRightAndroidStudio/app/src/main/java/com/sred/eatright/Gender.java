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

public class Gender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final DatabaseHelper db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        db = new DatabaseHelper(this);
        final RadioGroup radioGender = (RadioGroup) findViewById(R.id.radioGender);
        final RadioButton gender;
        final EditText heightFeet = (EditText) findViewById(R.id.height_feet);
        final EditText heightInches = (EditText) findViewById(R.id.height_inches);
        final EditText weight = (EditText) findViewById(R.id.weight);
        final Button nextButton = (Button) findViewById(R.id.button_next);

        int selectedGender = radioGender.getCheckedRadioButtonId();
        gender = (RadioButton) findViewById(selectedGender);



		nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Gender = gender.getText().toString().trim();
                final int heightft = Integer.parseInt(heightFeet.getText().toString().trim());
                final int heightin = Integer.parseInt(heightInches.getText().toString().trim());
                final int curWeight = Integer.parseInt(weight.getText().toString().trim());
                // FILL IN NEXT LINE //
                Long val = db.createFitnessProfile(Gender, heightft, heightin, curWeight);
                if (val>0) {
                    Intent moveToGetgoal = new Intent(Gender.this, Birthday.class);
//                    moveToGetgoal.putExtra("id",idkovalue);
                    startActivity(moveToGetgoal);
                }
                else {
                    Toast.makeText(Gender.this, "Please enter your information", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
