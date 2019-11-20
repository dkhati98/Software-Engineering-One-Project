package com.sred.eatright;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActivityLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_level);

       final RadioGroup radioActivity = (RadioGroup) findViewById(R.id.radio_activity_level);
       final RadioButton activityLevel;
       final Button calculate = (Button) findViewById(R.id.button_calculate);

       int selectedLevel = radioActivity.getCheckedRadioButtonId();
       activityLevel = (RadioButton)findViewById(selectedLevel);

       final String activitylevel = activityLevel.getText().toString().trim();

       calculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (true/*data > 0same as below*/) {
                   //insert code to save to DB: activity level
                   if (true/*datasuccesfullySavedToDB* commented this cause we dont have this method implemented yet*/) {
                       Intent moveToActivityLevel = new Intent(ActivityLevel.this, GoalsCalculated.class);
                       startActivity(moveToActivityLevel);
                   } else {
                       Toast.makeText(ActivityLevel.this, "Unable to access Internet", Toast.LENGTH_SHORT).show();
                   }
               } else {
                   Toast.makeText(ActivityLevel.this, "Choose an activity level", Toast.LENGTH_SHORT).show();
               }
           }
       });
}
}
