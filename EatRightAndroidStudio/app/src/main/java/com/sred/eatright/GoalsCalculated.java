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


        DatabaseGetter dbGetter = new DatabaseGetter();
        Profile profile = dbGetter.GetDB(_id);

        String usersName= profile.getUsersName();
        String userEmail= profile.getUserEmail();



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
