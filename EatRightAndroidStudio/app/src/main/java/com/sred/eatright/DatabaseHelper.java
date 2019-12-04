
package com.sred.eatright;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.sred.eatright.userDiary.Food;
import com.sred.eatright.userDiary.FoodLogAdapter;
import com.sred.eatright.userInfo.Profile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public  class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="eatright.db";
    public static final String TABLE_NAME="Profile";
    public static final String COL_1="_id";
    public static final String COL_2="userName";
    public static final String COL_3="emailAddress";
    public static final String COL_4="password";
    Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 3);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCreateProfile = "CREATE TABLE Profile (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "userName TEXT," +
                "password TEXT," +
//                "timeZone TEXT," +
                "emailAddress TEXT," +
//                "zip INTEGER," +
//                "location TEXT," +
                "heightft INTEGER, " +
                "heightin INTEGER, " +
                "age INTEGER," +
                "birthYear INTEGER," +
                "birthMonth INTEGER," +
                "birthDate INTEGER," +
                "gender TEXT," +
                "curWeight INTEGER," +
//                "goalWeight INTEGER," +
                "fitnessGoal TEXT," +
                "activityLevel TEXT," +
                "goalCalories INTEGER," +
//                "goalFat INTEGER," +
//                "goalProtein INTEGER," +
//                "goalCarbohydrates INTEGER," +
                "CONSTRAINT fk_users " +
                "FOREIGN KEY (_id,userName, password, emailAddress)" +
                "REFERENCES Users(_id,userName,password, emailAddress));";

        String queryCreateFoodDiary = "CREATE TABLE FoodDiary (_id INTEGER ," +
                "waterTracker INTEGER," +
                "PRIMARY KEY (_id)," +
                "CONSTRAINT fk_profile " +
                "FOREIGN KEY (_id)" +
                "REFERENCES Profile(_id));";

        String queryCreateMeals = "CREATE TABLE Meals (_id INTEGER ," +
                "mealType TEXT ," +
                "overAllFat INTEGER," +
                "overAllProtein INTEGER," +
                "overAllCarbohydrates INTEGER," +
                "overAllCalories INTEGER," +
                "PRIMARY KEY (_id, mealType)," +
                "CONSTRAINT fk_FoodDiary " +
                "FOREIGN KEY (_id)" +
                "REFERENCES Profile(_id));";

        String queryCreateFoods = "CREATE TABLE Foods (_Foodid INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "foodName TEXT," +
                "calories INTEGER," +
                "carbohydrates INTEGER," +
                "protein INTEGER," +
                "fat INTEGER);";

        String queryCreateMealFood = "CREATE TABLE MealFoods (_id INTEGER," +
                "_Foodid INTEGER," +
                "mealType TEXT ," +
                "calories INTEGER," +
                "PRIMARY KEY(_id, mealType,_Foodid)," +
                "CONSTRAINT fk_Profile " +
                "FOREIGN KEY (_id)" +
                "REFERENCES Profile(_id)," +
                "CONSTRAINT fk_Foods " +
                "FOREIGN KEY (_Foodid)" +
                "REFERENCES Foods(_Foodid))";

        db.execSQL(queryCreateProfile);
        db.execSQL(queryCreateFoodDiary);
        db.execSQL(queryCreateMeals);
        db.execSQL(queryCreateFoods);
        db.execSQL(queryCreateMealFood);
    }

    public int addFood(String foodName, int calories, int carbohydrates, int protein, int fat)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("foodName",foodName);
        contentValues.put("calories",calories);
        contentValues.put("carbohydrates",carbohydrates);
        contentValues.put("protein",protein);
        contentValues.put("fat",fat);

        long res = db.insert("Foods",null,contentValues);
        db.close();
        return getFoodid(foodName);
    }
    int calories;

    public long addFoodMeal(int foodID, String mealType, int calories){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("_Foodid",foodID);
        contentValues.put("mealType", mealType);
        contentValues.put("calories", calories);

        long res = db.insert("MealFoods",null,contentValues);
        db.close();
        return res;
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

//    public long addFoodMeal()
//    public int GetUserGoalCalories(int _id){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor getidcursor = db.query("Profile",
//                new String[]{"_id, userName"}, "userName = ?", new String[]{userName}, null, null, null);
//        return GoalCalories;
//        if (getidcursor.moveToFirst()) {
//            returnvalue= getidcursor.getInt(0);
//        }
//    }

    public List<Food> getFoodList(int _id, String mealType){
        List<Food> foodList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor getFoodCursor = db.query("MealFoods"
                ,new String[]{"_FoodID, calories"}, "_id = ? and mealType = ?",
                new String[]{Integer.toString(_id),mealType},null,null,null);
        Log.e("FOOD LOG", "  AASDSADSADASDSADASDSADSADSA");
        if (getFoodCursor.moveToFirst())
        {
            Food food;
            while (!getFoodCursor.isAfterLast()){
                food = new Food();
                food.setFoodID(Integer.parseInt(getFoodCursor.getString(2)));
                food.setCalories((Integer.parseInt(getFoodCursor.getString(3))));
                foodList.add(food);
                Log.e("FOOD LOG", food.getName() + "  ABCD");
                getFoodCursor.moveToNext();
            }
        }
        Food food = new Food();
        food.setName("asd");
        food.setCalories(12);
        foodList.add(food);
        db.close();
        return foodList;
    }
    public int getid(String userName) {
        int returnvalue = 0;
//        try {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor getidcursor = db.query("Profile",
                new String[]{"_id, userName"}, "userName = ?", new String[]{userName}, null, null, null);
        if (getidcursor.moveToFirst()) {
            returnvalue= getidcursor.getInt(0);
        }
//        } catch (SQLiteException e) {
//            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
//            toast.show();
//        }
        return returnvalue;
    }

    public int getFoodid(String foodName) {
        int returnvalue = 0;
//        try {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor getidcursor = db.query("Foods",
                new String[]{"_Foodid, foodName"}, "foodName = ?", new String[]{foodName}, null, null, null);
        if (getidcursor.moveToFirst()) {
            returnvalue= getidcursor.getInt(0);
        }
//        } catch (SQLiteException e) {
//            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
//            toast.show();
//        }
        return returnvalue;
    }

    public Profile GetDB(int _id) {
        Profile profile = new Profile();

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query("Profile",
                new String[]{"_id", "userName", "emailAddress", "gender",
                        "birthMonth", "birthDate", "birthYear",
                        "heightft", "heightin", "fitnessGoal",
                        "curWeight", "age", "activityLevel", "goalCalories"},
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
            profile.setUserFitnessGoal(cursor.getString(9));
            profile.setUserWeight(cursor.getString(10));
            profile.setUserAge(cursor.getString(11));
            profile.setUserActivityLevel(cursor.getString(12));
            profile.setUserGoalCalories(cursor.getString(13));
            cursor.close();
            db.close();
            return profile;
        }
        return profile;
    }


    public String getAge(int year, int month, int day){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }


    public  long updateUserBirthday(int _id, int birthYear, int birthMonth, int birthDate, int age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put("birthYear", birthYear);
        args.put("birthMonth", birthMonth);
        args.put("birthDate", birthDate);
        args.put("age", age);

        long res = db.update("Profile",
                args,
                "_id = ?",
                new String[] {Integer.toString(_id)});
        db.close();
        return res;
    }

    public  long updateUserInfo(int _id, String gender, int heightft, int heightin, int curWeight){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put("gender",gender);
        args.put("heightft", heightft);
        args.put("heightin", heightin);
        args.put("curWeight", curWeight);
        long res = db.update("Profile",
                args,
                "_id = ?",
                new String[] {Integer.toString(_id)});
        db.close();
        return res;
    }

    public long updateUserFitnessGoal(int _id, String goal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put("fitnessGoal", goal);
        long res = db.update("Profile",
                args,
                "_id = ?",
                new String[] {Integer.toString(_id)});
        db.close();
        return res;
    }

//    public void updateUserWeight(int _id, int curWeight){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues args = new ContentValues();
//        args.put("curWeight", curWeight);
//        long res = db.update("Profile",
//                args,
//                "_id = ?",
//                new String[] {Integer.toString(_id)});
//        db.close();
//
//    }



//    public static void createProfile(SQLiteDatabase db, String userName, String password, String timeZone,
//                                     String emailAddress, int zip, String location, int heightft,
//                                     int heightin, String firstName, String lastName, int age, String gender,
//                                     int curWeight, int goalWeight, String fitnessGoal, String activityLevel,
//                                     String goalCalories, String goalFat, String goalProtein, String goalCarbohydrates){
//
//        ContentValues profileValues = new ContentValues();
//        profileValues.put("userName", userName);
//        profileValues.put("password", password);
//        profileValues.put("timeZone", timeZone);
//        profileValues.put("emailAddress", emailAddress);
//        profileValues.put("zip", zip);
//        profileValues.put("location", location);
//        profileValues.put("heightft", heightft);
//        profileValues.put("heightin", heightin);
//        profileValues.put("firstName", firstName);
//        profileValues.put("lastName", lastName);
//        profileValues.put("age", age);
//        profileValues.put("gender", gender);
//        profileValues.put("curWeight", curWeight);
//        profileValues.put("goalWeight", goalWeight);
//        profileValues.put("fitnessGoal", fitnessGoal);
//        profileValues.put("goalFat", goalFat);
//        profileValues.put("activityLevel", activityLevel);
//        profileValues.put("goalCalories", goalCalories);
//        profileValues.put("goalProtein", goalProtein);
//        profileValues.put("goalCarbohydrates", goalCarbohydrates);
//
//        db.insert("Profile", null, profileValues);
//    }


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

    public long updateUserGoalCalories(int _id, double goalCalories) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put("goalCalories", (int)goalCalories);
        long res = db.update("Profile",
                args,"_id = ?",
                new String[] {Integer.toString(_id)});
        db.close();

        return res;
    }


    public Long updateUserActivityLevel(int _id, String activityLevel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put("activityLevel", activityLevel);
        long res = db.update("Profile",
                args,"_id = ?",
                new String[] {Integer.toString(_id)});
        db.close();

        return res;
    }
}
