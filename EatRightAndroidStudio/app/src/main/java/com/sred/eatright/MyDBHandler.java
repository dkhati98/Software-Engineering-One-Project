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


    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCreateUsers = "CREATE TABLE Users (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                         "userName TEXT," +
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
                                                             "goalCarbohydrates INTEGER);";

        String queryCreateFoodDiary = "CREATE TABLE FoodDiary (_id INTEGER PRIMARY KEY," +
                                                                "waterTracker INTEGER," +
                                                                "Date TEXT PRIMARY KEY," +
                                                                "CONSTRAINT fk_profile " +
                                                                "FOREIGN KEY (_id)" +
                                                                "REFERENCES Profile(_id));";

        String queryCreateMeals = "CREATE TABLE Meals (_id INTEGER PRIMARY KEY," +
                                                        "mealType TEXT PRIMARY KEY," +
                                                        "Date Text PRIMARY KEY," +
                                                        "overAllFat INTEGER," +
                                                        "overAllProtein INTEGER," +
                                                        "overAllCarbohydrates INTEGER," +
                                                        "overAllCalories INTEGER," +
                                                        "CONSTRAINT fk_FoodDiary " +
                                                        "FOREIGN KEY (_id, Date)" +
                                                        "REFERENCES Profile(_id, Date));";

        String queryCreateFoods = "CREATE TABLE Foods (_Foodid INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                        "calories INTEGER," +
                                                        "carbohydrates INTEGER," +
                                                        "protein INTEGER," +
                                                        "fat INTEGER);";

        String queryCreateMealFood = "CREATE TABLE MealFood(_id INTEGER PRIMARY KEY," +
                                                            "mealType TEXT PRIMARY KEY," +
                                                            "Date TEXT PRIMARY KEY," +
                                                            "_Foodid INTEGER PRIMARY KEY," +
                                                            "CONSTRAINT fk_Meals " +
                                                            "FOREIGN KEY (_id, mealType, Date)" +
                                                            "REFERENCES users(_id, mealType, Date)," +
                                                            "CONSTRAINT fk_Foods " +
                                                            "FOREIGN KEY (_Foodid)" +
                                                            "REFERENCES Foods(_Foodid))";

        sqLiteDatabase.execSQL(queryCreateUsers);
        sqLiteDatabase.execSQL(queryCreateProfile);
        sqLiteDatabase.execSQL(queryCreateFoodDiary);
        sqLiteDatabase.execSQL(queryCreateMeals);
        sqLiteDatabase.execSQL(queryCreateFoods);
        sqLiteDatabase.execSQL(queryCreateMealFood);
    }

    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}


