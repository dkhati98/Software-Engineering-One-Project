package com.sred.eatright.userInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sred.eatright.DatabaseHelper;
import com.sred.eatright.R;

public class ActivityLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_level);
        final DatabaseHelper db;
        db = new DatabaseHelper(this);
        final RadioGroup radioActivity = (RadioGroup) findViewById(R.id.radio_activity_level);

        final Button calculate = (Button) findViewById(R.id.button_calculate);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final RadioButton activityLevel;
                final int selectedLevel = radioActivity.getCheckedRadioButtonId();
                Log.d("selectedLevel:", selectedLevel + " ");
                activityLevel = (RadioButton) findViewById(selectedLevel);

                final String realactivitylevel = activityLevel.getText().toString().trim();
                final int _id = (Integer) getIntent().getExtras().get("id");
                Long val = db.updateUserActivityLevel(_id, realactivitylevel);
                Log.d("activityLevel", realactivitylevel + " ");

                if (val > 0) {

                    Intent moveToGoalsCalculated = new Intent(ActivityLevelActivity.this, GoalCalculatedActivity.class);
                    moveToGoalsCalculated.putExtra("id", _id);
                    startActivity(moveToGoalsCalculated);
                } else {
                    Toast.makeText(ActivityLevelActivity.this, "Unable to access Internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}



