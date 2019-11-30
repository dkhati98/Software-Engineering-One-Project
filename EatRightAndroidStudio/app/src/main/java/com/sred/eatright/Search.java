package com.sred.eatright;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final Button button_help = (Button) findViewById(R.id.button_help);
        final Button button_home = (Button) findViewById(R.id.button_home);
        final Button button_profile = (Button) findViewById(R.id.button_profile);
        final EditText search_bar = (EditText) findViewById(R.id.search_bar);

        //Insert code for search bar

        //help button
        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelp = new Intent(Search.this, Help.class);
                startActivity(moveToHelp);
            }
        });

        //home screen button
        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToSearch = new Intent(Search.this, Home.class);
                startActivity(moveToSearch);
            }
        });

        //profile button
        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToProfile = new Intent(Search.this, ProfileActivity.class);
                startActivity(moveToProfile);
            }
        });

    }
}
