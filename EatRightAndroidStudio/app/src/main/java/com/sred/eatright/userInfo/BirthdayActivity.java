package com.sred.eatright.userInfo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.DatePicker;

import com.sred.eatright.DatabaseHelper;
import com.sred.eatright.R;

public class BirthdayActivity extends AppCompatActivity {
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        final DatabaseHelper db;
        db = new DatabaseHelper(this);
        datePicker= (DatePicker)findViewById(R.id.datepicker);
        datePicker.setSpinnersShown(false);



        final Button nextButton = (Button) findViewById(R.id.button_next);
        final DatabaseHelper databaseHelper = new DatabaseHelper(this);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int day = datePicker.getDayOfMonth();
                final int month = datePicker.getMonth()+1;
                final int year = datePicker.getYear();
                int _id = (Integer)getIntent().getExtras().get("id");

                int age = Integer.parseInt(databaseHelper.getAge(year, month, day));
                Log.d("ageHere",year+" "+month+" "+day);
                long val = db.updateUserBirthday(_id, year, month, day, age);
                if (val > 0) {
                    Intent moveToGetgoal = new Intent(BirthdayActivity.this, GetGoalActivity.class);
                    moveToGetgoal.putExtra("id",_id);
                    startActivity(moveToGetgoal);
                    Toast.makeText(BirthdayActivity.this, "Select your Goal.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(BirthdayActivity.this, "Unable to connect to Database.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
