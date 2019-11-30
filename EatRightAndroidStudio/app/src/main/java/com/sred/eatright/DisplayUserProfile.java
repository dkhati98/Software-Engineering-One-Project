package com.sred.eatright;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import android.content.Context;
import android.database.Cursor;
import android.content.ContentValues;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class DisplayUserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user_profile);
        int _id = (Integer) getIntent().getExtras().get("id");

        SQLiteOpenHelper eatrightDatabaseHelper = new DatabaseHelper(this);

        try {
             SQLiteDatabase db = eatrightDatabaseHelper.getWritableDatabase();


            Cursor cursor = db.query("Profile",
                    new String[]{"_id", "userName", "emailAddress",
                            "heightft", "heightin",
                            "birthYear", "birthMonth", "birthDate", "curWeight"},
                    "_id = ?",
                    new String[]{Integer.toString(_id)},
                    null, null, "_int");

            if (cursor.moveToFirst()) {
                int idText = cursor.getInt(0);
                String userNameText = cursor.getString(1);
                String emailAddresssText = cursor.getString(2);
            }
            cursor.close();
            db.close();
//        public void displayUserProfile{

        } catch(SQLiteException e){
            Toast toast = Toast.makeText(this,"Database Unavailaible", Toast.LENGTH_SHORT);
            toast.show();
        }
//    }
    }
}
