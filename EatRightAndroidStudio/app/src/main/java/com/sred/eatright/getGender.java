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

import static java.lang.Integer.parseInt;

public class getGender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

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

                final String userGender = gender.toString().trim();
                final int userHeight = parseInt(heightFeet.getText().toString().trim()) * 12 + parseInt(heightInches.getText().toString().trim());
                final String userWeight = weight.getText().toString().trim();

                if ((userGender != null) && (userHeight != 0) && (userWeight != null)) {
                    //fill in code to save to DB

                    Intent moveToGetgoal = new Intent(getGender.this, Birthday.class);
                    startActivity(moveToGetgoal);
                } else {
                    Toast.makeText(getGender.this, "Unable to connect to the internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
