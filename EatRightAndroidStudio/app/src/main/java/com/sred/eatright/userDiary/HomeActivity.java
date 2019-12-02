package com.sred.eatright.userDiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.sred.eatright.R;
import com.sred.eatright.userInfo.ProfileActivity;

public class HomeActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final int _id = (Integer)getIntent().getExtras().get("id");
        final Button button_help = (Button) findViewById(R.id.button_help);
        final Button button_search = (Button) findViewById(R.id.button_search);
        final Button button_profile = (Button) findViewById(R.id.button_profile);
        final Button add_breakfast = (Button) findViewById(R.id.button_add_breakfast);
        final Button add_lunch = (Button) findViewById(R.id.button_add_lunch);
        final Button add_dinner = (Button) findViewById(R.id.button_add_dinner);
        final Button add_snacks = (Button) findViewById(R.id.button_add_snacks);

        //search and add to breakfast button
        add_breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToSearch = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(moveToSearch);
            }
        });

        //search and add to lunch button
        add_lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToSearch = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(moveToSearch);
            }
        });

        //search and add to dinner button
        add_dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToSearch = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(moveToSearch);
            }
        });

        //search and add to snacks button
        add_snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToSearch = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(moveToSearch);
            }
        });

        //help button
        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelp = new Intent(HomeActivity.this, HelpActivity.class);
                startActivity(moveToHelp);
            }
        });

        //search screen button
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToSearch = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(moveToSearch);
            }
        });

        //profile button
        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToProfile = new Intent(HomeActivity.this, ProfileActivity.class);
                moveToProfile.putExtra("id",_id);
                startActivity(moveToProfile);
            }
        });
    }
}
