package com.sred.eatright;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final TextView usersName = (TextView) findViewById(R.id.user_name);
        final TextView userEmail = (TextView) findViewById(R.id.user_email);
        final TextView userGender = (TextView) findViewById(R.id.user_gender);
        final TextView userDOB = (TextView) findViewById(R.id.user_dob);
        final TextView userHeightFeet = (TextView) findViewById(R.id.user_heightFeet);
        final TextView userHeightInches = (TextView) findViewById(R.id.user_heightInches);
        final TextView userGoal = (TextView) findViewById(R.id.user_goal);
        final TextView userWeight = (TextView) findViewById(R.id.user_current_weight);
        final EditText updateWeight = (EditText) findViewById(R.id.user_new_weight);
        final Button buttonSave = (Button) findViewById(R.id.button_save);
        final Button button_help = (Button) findViewById(R.id.button_help);
        final Button button_search = (Button) findViewById(R.id.button_search);
        final Button button_home = (Button) findViewById(R.id.button_home);

        //Insert code to set TextViews to user's saved DB information

        final String userUpdatedWeight = updateWeight.getText().toString().trim();
        //insert code to overwrite old userWeight to userUpdatedWeight

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert code to recalculate weight using userUpdatedWeight
                Intent moveToRefresh = new Intent(ProfileActivity.this, ProfileActivity.class);
                startActivity(moveToRefresh);
            }
    });

        //help button
        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelp = new Intent(ProfileActivity.this, Help.class);
                startActivity(moveToHelp);
            }
        });

        //search screen button
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToSearch = new Intent(ProfileActivity.this, Search.class);
                startActivity(moveToSearch);
            }
        });

        //home button
        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHome = new Intent(ProfileActivity.this, Home.class);
                startActivity(moveToHome);
            }
        });
    }
}
