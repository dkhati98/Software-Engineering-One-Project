//package com.sred.eatright;
//
//import com.sred.eatright.userDiary.FoodDiary;
//import com.sred.eatright.userInfo.Profile;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Log {
//    private Profile profile;
//    private List<FoodDiary> FoodDiaryList = new ArrayList<>();
//
//    /**
//     * pass profile to create a FoodDiary class
//     * @param profile
//     */
//    public Log(Profile profile) {
//        this.profile = profile;
//        addFoodDiary();
//    }
//
//    /**
//     * create FoodDiary class
//     * will create multiple that correspond with each date
//     */
//    private void addFoodDiary() {
//        //will use for loop to initialize all the FoodDiary for the account
//        //for (int i = 0; i < 10; i++) {
//            FoodDiaryList.add(new FoodDiary(profile));
//        //}
//    }
//
//    /**
//     * returns a FoodDiaryList
//     * @return a list
//     */
//    public List<FoodDiary> getFoodDiaryList() {
//        return FoodDiaryList;
//    }
//}
