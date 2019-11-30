package com.sred.eatright;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="eatright.db";
    public static final String TABLE_NAME="Users";
    public static final String COL_1="_id";
    public static final String COL_2="userName";
    public static final String COL_3="emailAddress";
    public static final String COL_4="password";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//       db.execSQL("CREATE TABLE userTable (_id INTEGER PRIMARY KEY AUTOINCREMENT, userName TEXT, emailAddress TEXT, password TEXT)");

        String queryCreateUsers = "CREATE TABLE Users (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "userName TEXT," +
                "emailAddress TEXT," +
                "password TEXT);";

        String queryCreateProfile = "CREATE TABLE Profile (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "userName TEXT," +
                "password TEXT," +
                "timeZone TEXT," +
                "emailAddress TEXT," +
                "zip INTEGER," +
                "location TEXT," +
                "heightft INTEGER, " +
                "heightin INTEGER, " +
                "firstName TEXT," +
                "lastName TEXT," +
                "age INTEGER," +
                "gender TEXT," +
                "curWeight INTEGER," +
                "goalWeight INTEGER," +
                "fitnessGoal TEXT," +
                "activityLevel TEXT," +
                "goalCalories INTEGER," +
                "goalFat INTEGER," +
                "goalProtein INTEGER," +
                "goalCarbohydrates INTEGER," +
                "CONSTRAINT fk_users " +
                "FOREIGN KEY (_id,userName, password, emailAddress)" +
                "REFERENCES Users(_id,userName,password, emailAddress));";

        String queryCreateFitnessProfile = "CREATE TABLE Profile (_id INTEGER PRIMARY KEY," +
                "heightft INTEGER, " +
                "heightin INTEGER, " +
                "gender TEXT," +
                "curWeight INTEGER," +
                "CONSTRAINT fk_users " +
                "FOREIGN KEY (_id)" +
                "REFERENCES Users(_id));";

        String queryCreateFoodDiary = "CREATE TABLE FoodDiary (_id INTEGER ," +
                "waterTracker INTEGER," +
                "Date TEXT ," +
                "PRIMARY KEY (_id, Date)," +
                "CONSTRAINT fk_profile " +
                "FOREIGN KEY (_id)" +
                "REFERENCES Profile(_id));";

        String queryCreateMeals = "CREATE TABLE Meals (_id INTEGER ," +
                "mealType TEXT ," +
                "Date Text ," +
                "overAllFat INTEGER," +
                "overAllProtein INTEGER," +
                "overAllCarbohydrates INTEGER," +
                "overAllCalories INTEGER," +
                "PRIMARY KEY (_id, mealType, Date)," +
                "CONSTRAINT fk_FoodDiary " +
                "FOREIGN KEY (_id, Date)" +
                "REFERENCES Profile(_id, Date));";

        String queryCreateFoods = "CREATE TABLE Foods (_Foodid INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "foodName TEXT," +
                "calories INTEGER," +
                "carbohydrates INTEGER," +
                "protein INTEGER," +
                "fat INTEGER);";

        String queryCreateMealFood = "CREATE TABLE MealFood(_id INTEGER," +
                "mealType TEXT ," +
                "Date TEXT ," +
                "_Foodid INTEGER ," +
                "PRIMARY KEY(_id, mealType, Date,_Foodid)," +

                "CONSTRAINT fk_Meals " +
                "FOREIGN KEY (_id, mealType, Date)" +
                "REFERENCES users(_id, mealType, Date)," +
                "CONSTRAINT fk_Foods " +
                "FOREIGN KEY (_Foodid)" +
                "REFERENCES Foods(_Foodid))";

        db.execSQL(queryCreateUsers);
        db.execSQL(queryCreateFitnessProfile);
        db.execSQL(queryCreateProfile);
        db.execSQL(queryCreateFoodDiary);
        db.execSQL(queryCreateMeals);
        db.execSQL(queryCreateFoods);
        db.execSQL(queryCreateMealFood);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME +"'");
        onCreate(db);
    }
    public long addUser(String userName, String emailAddress,  String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("userName",userName);
        contentValues.put("emailAddress",emailAddress);
        contentValues.put("password",password);
        long res = db.insert("Profile",null,contentValues);
        db.close();
        return res;
    }

    public  Long createFitnessProfile(String gender, int heightft, int heightin, int curWeight){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues fitnessProfileValues = new ContentValues();
        fitnessProfileValues.put("gender", gender);
        fitnessProfileValues.put("heightft", heightft);
        fitnessProfileValues.put("heightin", heightin);
        fitnessProfileValues.put("curWeight", curWeight);
        Long res = db.insert("Profile", null, fitnessProfileValues);
        db.close();
        return res;
    }

    public void addAge(){}

    public void addActivityLevel(){}

    public void addGoal(){}

    public void addLoseWeight(){}

    public void addGainWeight(){}





    public static void createProfile(SQLiteDatabase db, String name, String password, String timeZone,
                                     String emailAddress, int zip, String location, String firstName, String lastName, int age,
                                     int goalWeight, String fitnessGoal, String activityLevel,
                                     String goalCalories, String goalFat, String goalProtein, String goalCarbohydrates){

        ContentValues profileValues = new ContentValues();
        profileValues.put("userName", name);
        profileValues.put("password", password);
        profileValues.put("timeZone", timeZone);
        profileValues.put("emailAddress", emailAddress);
        profileValues.put("zip", zip);
        profileValues.put("location", location);

        profileValues.put("firstName", firstName);
        profileValues.put("lastName", lastName);
        profileValues.put("age", age);

        profileValues.put("goalWeight", goalWeight);
        profileValues.put("fitnessGoal", fitnessGoal);
        profileValues.put("goalFat", goalFat);
        profileValues.put("activityLevel", activityLevel);
        profileValues.put("goalCalories", goalCalories);
        profileValues.put("goalProtein", goalProtein);
        profileValues.put("goalCarbohydrates", goalCarbohydrates);

        db.insert("Profile", null, profileValues);
    }


    public boolean checkUser(String userName, String password)
    {
        String[] columns ={COL_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + "and "+ COL_4 + "=?";
        String[] selectionArgs = {userName, password};
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
