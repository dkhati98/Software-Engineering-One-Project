package com.sred.eatright.userInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sred.eatright.DatabaseHelper;
import com.sred.eatright.R;

import static java.lang.Integer.parseInt;

public class getGender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        final DatabaseHelper db;
        db = new DatabaseHelper(this);
        final RadioGroup radioGender = (RadioGroup) findViewById(R.id.radioGender);
        final RadioButton gender;
        final EditText heightFeet = (EditText) findViewById(R.id.height_feet);
        final EditText heightInches = (EditText) findViewById(R.id.height_inches);
        final EditText weight = (EditText) findViewById(R.id.weight);
        final Button nextButton = (Button) findViewById(R.id.button_next);

        int selectedGender = radioGender.getCheckedRadioButtonId();
        gender = (RadioButton) findViewById(selectedGender);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Gender = gender.getText().toString().trim();
                final int heightft = Integer.parseInt(heightFeet.getText().toString().trim());
                final int heightin = Integer.parseInt(heightInches.getText().toString().trim());
                final int curWeight = Integer.parseInt(weight.getText().toString().trim());

                int _id = (Integer)getIntent().getExtras().get("id");
                long val = db.updateUserInfo(_id, Gender, heightft, heightin, curWeight);

                if (val > 0) {
                    //fill in code to save to DB
                    Intent moveToBirthday = new Intent(getGender.this, Birthday.class);
                    moveToBirthday.putExtra("id",_id);
                    startActivity(moveToBirthday);
                    Toast.makeText(getGender.this, "Please enter your information", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getGender.this, "Unable to connect to the internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

//works