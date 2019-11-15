package com.sred.eatright;

import java.util.ArrayList;
import java.util.List;

public class Log {
    private Profile profile;
    private List<FoodDiary> FoodDiaryList = new ArrayList<>();

    public Log(Profile profile) {
        this.profile = profile;
        addFoodDiary();
    }

    private void addFoodDiary() {
        //will use for loop to initialize all the FoodDiary for the account
        //for (int i = 0; i < 10; i++) {
            FoodDiaryList.add(new FoodDiary(profile));
        //}
    }

    public List<FoodDiary> getFoodDiaryList() {
        return FoodDiaryList;
    }
}
