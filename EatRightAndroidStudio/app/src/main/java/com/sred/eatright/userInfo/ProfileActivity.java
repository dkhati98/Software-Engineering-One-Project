package com.sred.eatright.userInfo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sred.eatright.DatabaseHelper;
import com.sred.eatright.userDiary.Help;
import com.sred.eatright.userDiary.Home;
import com.sred.eatright.R;
import com.sred.eatright.userDiary.Search;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        final int _id = (Integer) getIntent().getExtras().get("id");

        SQLiteOpenHelper eatrightDatabaseHelper = new DatabaseHelper(this);

        try {
            SQLiteDatabase db = eatrightDatabaseHelper.getWritableDatabase();


            Cursor cursor = db.query("Profile",
                    new String[]{"_id", "userName", "emailAddress", "gender",
                            "birthMonth", "birthDate", "birthYear",
                            "heightft", "heightin", "fitnessGoal",
                              "curWeight"},
                    "_id = ?",
                    new String[]{Integer.toString(_id)},
                    null, null, "_id");

            if (cursor.moveToFirst()) {
                int idText = cursor.getInt(0);
                String usersName = cursor.getString(1);
                String userEmail = cursor.getString(2);
                String userGender = cursor.getString(3);
                String userDOB_month = cursor.getString(4);
                String userDOB_day = cursor.getString(5);
                String userDOB_year = cursor.getString(6);
                String userHeightFeet = cursor.getString(7);
                String userHeightInches = cursor.getString(8);
                String userGoal = cursor.getString(9);
                String userWeight = cursor.getString(10);

                final TextView user_name = (TextView) findViewById(R.id.user_name);
                user_name.setText(usersName);
                final TextView user_email = (TextView) findViewById(R.id.user_email);
                user_email.setText(userEmail);
                final TextView user_gender = (TextView) findViewById(R.id.user_gender);
                user_gender.setText(userGender);
                final TextView user_dob_month = (TextView) findViewById(R.id.user_dob_month);
                user_dob_month.setText(userDOB_month);
                final TextView user_dob_day = (TextView) findViewById(R.id.user_dob_day);
                user_dob_day.setText(userDOB_day);
                final TextView user_dob_year = (TextView) findViewById(R.id.user_dob_year);
                user_dob_year.setText(userDOB_year);
                final TextView user_heightFeet = (TextView) findViewById(R.id.user_heightFeet);
                user_heightFeet.setText(userHeightFeet);
                final TextView user_heightInches = (TextView) findViewById(R.id.user_heightInches);
                user_heightInches.setText(userHeightInches);
                final TextView user_goal = (TextView) findViewById(R.id.user_goal);
                user_goal.setText(userGoal);
                final TextView user_current_weight = (TextView) findViewById(R.id.user_current_weight);
                user_current_weight.setText(userWeight);

            }
            cursor.close();
            db.close();
//        public void displayUserProfile{

        } catch(SQLiteException e){
            Toast toast = Toast.makeText(this,"Database Unavailaible", Toast.LENGTH_SHORT);
            toast.show();
        }



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
                moveToHome.putExtra("id",_id);
                startActivity(moveToHome);
            }
        });
    }
}
