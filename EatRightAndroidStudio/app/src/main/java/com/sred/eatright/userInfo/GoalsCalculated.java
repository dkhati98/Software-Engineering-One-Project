package com.sred.eatright.userInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sred.eatright.R;
import com.sred.eatright.userDiary.Home;

public class GoalsCalculated extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_calculated);
        final int _id = (Integer)getIntent().getExtras().get("id");
        final Button next = (Button) findViewById(R.id.button_next);
        //add setText

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
