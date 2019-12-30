
package com.sred.eatright.userInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sred.eatright.DatabaseHelper;
import com.sred.eatright.R;

import static java.lang.Integer.parseInt;

public class GetGenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        final DatabaseHelper db;
        db = new DatabaseHelper(this);
        final RadioGroup radioGender = (RadioGroup) findViewById(R.id.radioGender);

        final EditText heightFeet = (EditText) findViewById(R.id.height_feet);
        final EditText heightInches = (EditText) findViewById(R.id.height_inches);
        final EditText weight = (EditText) findViewById(R.id.weight);
        final Button nextButton = (Button) findViewById(R.id.button_next);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RadioButton gender;
                int selectedGender = radioGender.getCheckedRadioButtonId();
                gender = (RadioButton) findViewById(selectedGender);

                final String Gender = gender.getText().toString().trim();

                int heightft=0;
                int heightin=0;
                int curWeight=0;
                try {


                    heightft = Integer.parseInt(heightFeet.getText().toString().trim());
                    heightin = Integer.parseInt(heightInches.getText().toString().trim());
                    curWeight = Integer.parseInt(weight.getText().toString().trim());
               }catch (Exception e)
               {
                   Toast.makeText(GetGenderActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
               }
                int _id = (Integer)getIntent().getExtras().get("id");

                Log.d("genderHere", Gender+" ");
                Log.d("idatgender",_id+" ");

                if(heightft==0)
                    Toast.makeText(GetGenderActivity.this, "Please enter your height", Toast.LENGTH_SHORT).show();
                else if(heightin==0||heightin>=12)
                    Toast.makeText(GetGenderActivity.this, "Please enter appropriate value for height in inches", Toast.LENGTH_SHORT).show();
                else if(curWeight==0)
                    Toast.makeText(GetGenderActivity.this, "Please enter your weight", Toast.LENGTH_SHORT).show();
                else {
                    long val = db.updateUserInfo(_id, Gender, heightft, heightin, curWeight);

                    if (val > 0) {
                        //fill in code to save to DB
                        Intent moveToBirthday = new Intent(GetGenderActivity.this, BirthdayActivity.class);
                        moveToBirthday.putExtra("id", _id);
                        Toast.makeText(GetGenderActivity.this, "Please enter your birthday.", Toast.LENGTH_SHORT).show();
                        startActivity(moveToBirthday);
                        // Toast.makeText(GetGenderActivity.this, "Please enter your information", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(GetGenderActivity.this, "Unable to connect to Database.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

//works





