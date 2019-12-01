package com.sred.eatright;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DatabaseGetter extends AppCompatActivity {


    final SQLiteOpenHelper eatrightDatabaseHelper = new DatabaseHelper(this);




    Profile profile = new Profile();
    public Profile GetDB(int _id) {
        final SQLiteDatabase db = eatrightDatabaseHelper.getWritableDatabase();
        Cursor cursor = db.query("Profile",
                new String[]{"_id", "userName", "emailAddress", "gender",
                        "birthMonth", "birthDate", "birthYear",
                        "heightft", "heightin", "fitnessGoal",
                        "curWeight"},
                "_id = ?",
                new String[]{Integer.toString(_id)},
                null, null, "_id");

        if (cursor.moveToFirst()) {

            profile.setUsersName(cursor.getString(1));
            profile.setUserEmail(cursor.getString(2));
            profile.setUserGender(cursor.getString(3));
            profile.setUserDOB_month(cursor.getString(4));
            profile.setUserDOB_day(cursor.getString(5));
            profile.setUserDOB_year(cursor.getString(6));
            profile.setUserHeightFeet(cursor.getString(7));
            profile.setUserHeightInches(cursor.getString(8));
            profile.setUserGoal(cursor.getString(9));
            profile.setUserWeight(cursor.getString(10));

        }
        cursor.close();
        db.close();
        return profile;

    }




}


