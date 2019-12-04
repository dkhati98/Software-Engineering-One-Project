package com.sred.eatright.userDiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sred.eatright.R;
import com.sred.eatright.userInfo.ProfileActivity;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        final int _id = (Integer)getIntent().getExtras().get("id");

        final Button button_search = (Button) findViewById(R.id.button_search);
        final Button button_profile = (Button) findViewById(R.id.button_profile);
        final Button button_home = (Button) findViewById(R.id.button_home);

        //help button
        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelp = new Intent(HelpActivity.this, HomeActivity.class);
                moveToHelp.putExtra("id",_id);
                startActivity(moveToHelp);
            }
        });

        //search screen button
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("id",String.valueOf(_id));
                bundle.putString("mealType","non");
                Search myfragent = new Search();
                myfragent.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, myfragent, myfragent.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });

        //profile button
        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToProfile = new Intent(HelpActivity.this, ProfileActivity.class);
                moveToProfile.putExtra("id",_id);
                startActivity(moveToProfile);
            }
        });
    }
}
