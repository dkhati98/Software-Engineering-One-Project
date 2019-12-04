package com.sred.eatright.SignUpLogIn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sred.eatright.R;
import com.sred.eatright.userInfo.GetGenderActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);

        final Button nextButton = (Button) findViewById(R.id.button_next);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToGender = new Intent(WelcomeActivity.this, GetGenderActivity.class);
                int _id = (Integer)getIntent().getExtras().get("id");
                moveToGender.putExtra("id",_id);
                startActivity(moveToGender);
            }
        })
    ;}
}
