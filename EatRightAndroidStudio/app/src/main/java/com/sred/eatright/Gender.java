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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        final RadioGroup radioGender = (RadioGroup) findViewById(R.id.radioGender)
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

                if (data > 0) {
                    //fill in code to save to DB
                    if(dataSuccesfullySavedtoDB) {
                        Intent moveToGetgoal = new Intent(Gender.this, Birthday.class);
                        startActivity(moveToGetgoal);
                    }
                    else {
                        Toast.makeText(Gender.this, "Unable to connect to the internet", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Gender.this, "Please enter your information", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
