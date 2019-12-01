package com.sred.eatright;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GoalsCalculated extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_calculated);
        final int _id = (Integer)getIntent().getExtras().get("id");
        final Button next = (Button) findViewById(R.id.button_next);
        //add setText

        final SQLiteOpenHelper eatrightDatabaseHelper = new DatabaseHelper(this);
        try {

            final SQLiteDatabase db = eatrightDatabaseHelper.getWritableDatabase();


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
            }
            cursor.close();
            db.close();


    } catch(
    SQLiteException e){
        Toast toast = Toast.makeText(this,"Database Unavailaible", Toast.LENGTH_SHORT);
        toast.show();
    }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert code to view calculated goal
                Intent moveToHome = new Intent(GoalsCalculated.this, Home.class);
                moveToHome.putExtra("id",_id);
                startActivity(moveToHome);
            }
        });
    }}
