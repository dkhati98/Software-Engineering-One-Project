package com.sred.eatright.userDiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sred.eatright.R;
import com.sred.eatright.userInfo.ProfileActivity;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        final Button button_search = (Button) findViewById(R.id.button_search);
        final Button button_profile = (Button) findViewById(R.id.button_profile);
        final Button button_home = (Button) findViewById(R.id.button_home);

        //help button
        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelp = new Intent(Help.this, Home.class);
                startActivity(moveToHelp);
            }
        });

        //search screen button
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToSearch = new Intent(Help.this, Search.class);
                startActivity(moveToSearch);
            }
        });

        //profile button
        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToProfile = new Intent(Help.this, ProfileActivity.class);
                startActivity(moveToProfile);
            }
        });
    }
}
