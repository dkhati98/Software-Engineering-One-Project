package com.sred.eatright;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="UserS.db";
    public static final String TABLE_NAME="userTable";
    public static final String COL_1="UserId";
    public static final String COL_2="username";
    public static final String COL_3="useremail";
    public static final String COL_4="userpassword";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("CREATE TABLE userTable (UserId INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, useremail TEXT, userpassword TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME +"'");
        onCreate(db);
    }
public long addUser(String username, String useremail,  String password)
{
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues =new ContentValues();
    contentValues.put("username",username);
    contentValues.put("useremail",useremail);
    contentValues.put("userpassword",password);
    long res = db.insert("userTable",null,contentValues);
    db.close();
    return res;
}
public boolean checkUser(String username, String userpassword)
{
    String[] columns ={COL_1};
    SQLiteDatabase db = getReadableDatabase();
    String selection = COL_2 + "=?" + "and "+ COL_4 + "=?";
    String[] selectionArgs = {username, userpassword};
    Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
    int count = cursor.getCount();
    cursor.close();
    db.close();
    if(count>0)
        return true;
    else
        return false;


}

}
