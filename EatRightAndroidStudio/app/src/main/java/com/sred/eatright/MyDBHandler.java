package com.sred.eatright;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "eatright.db";
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";


    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_USERS + "(" +
                COLUMN_USERNAME + "VARCHAR PRIMARY KEY,"+
                COLUMN_PASSWORD + "VARCHAR"+
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(sqLiteDatabase);
    }

    //Add a new row to database
    public void addUser(User user) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.get_username());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(TABLE_USERS, null, values);
        sqLiteDatabase.close();
    }

    //Delete a user from database

    public void deleteUser (String userName){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME = "=\"" + userName + "\";")
    }

    public String databaseToString(){
        String dbString = " ";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE 1";

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        // Move to first row in your results
        c.moveToFirst();

        while(!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("userName")) != null){
                dbString += c.getString(c.getColumnIndex("userName"));
                dbString += "\n";
            }
        }
        sqLiteDatabase.close();
        return dbString;

    }


}
