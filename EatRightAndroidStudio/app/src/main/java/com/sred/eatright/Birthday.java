package com.sred.eatright;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.DatePicker;

public class Birthday extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        final DatabaseHelper db;
        db = new DatabaseHelper(this);
        DatePicker datePicker = (DatePicker)findViewById(R.id.datepicker);
        datePicker.setSpinnersShown(false);
        final int day = datePicker.getDayOfMonth();
        final int month = datePicker.getMonth();
        final int year = datePicker.getYear();
        final Button nextButton = (Button) findViewById(R.id.button_next);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int _id = (Integer)getIntent().getExtras().get("id");
                long val = db.updateUserBirthday(_id, day, month, year);
                if (val > 0) {
                        Intent moveToGetgoal = new Intent(Birthday.this, GetGoal.class);
                        moveToGetgoal.putExtra("id",_id);
                        startActivity(moveToGetgoal);
                     Toast.makeText(Birthday.this, "Select your birthday", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Birthday.this, "Unable to connect to the internet", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }
}
