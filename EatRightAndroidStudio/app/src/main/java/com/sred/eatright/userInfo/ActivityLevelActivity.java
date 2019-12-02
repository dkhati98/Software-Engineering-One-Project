package com.sred.eatright.userInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sred.eatright.R;

public class ActivityLevelActivity extends AppCompatActivity {

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
                       Intent moveToActivityLevel = new Intent(ActivityLevelActivity.this, GoalCalculatedActivity.class);
                       startActivity(moveToActivityLevel);
                   } else {
                       Toast.makeText(ActivityLevelActivity.this, "Unable to access Internet", Toast.LENGTH_SHORT).show();
                   }
               } else {
                   Toast.makeText(ActivityLevelActivity.this, "Choose an activity level", Toast.LENGTH_SHORT).show();
               }
           }
       });
}
}
