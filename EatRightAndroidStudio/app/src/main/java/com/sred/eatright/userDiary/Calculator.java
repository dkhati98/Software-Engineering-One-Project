//package com.sred.eatright.userDiary;
//
//import com.sred.eatright.userInfo.Profile;
//
///**
// * Calculator class used to get the goal calories and food calories, and calculate the remaining calories for the day
// */
//public class Calculator {
//    private int goal;
//    private int remaining;
//    private int foodCalories;
//
//    /**
//     * set the profile to its own profile and set overall calories to foodCalories
//     * @param profile
//     * @param overAllCalories
//     */
//    public Calculator(Profile profile, int overAllCalories){
//        goal = profile.getGoal().getNutrionGoal().getGoalCalories();
//        setFoodCalories(overAllCalories);
//        setRemaining();
//    }
//
//    /**
//     * set calories of all the food
//     * @param overAllCalories
//     */
//    public void setFoodCalories(int overAllCalories) {
//        foodCalories = overAllCalories;
//    }
//
//    /**
//     * set remaining calories
//     */
//    public void setRemaining() {
//        remaining = goal -  foodCalories;
//    }
//
//    /**
//     * get remaining calories
//     * @return remaining calories
//     */
//    public int getRemaining() {
//        return remaining;
//    }
//}
