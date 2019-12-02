//package com.sred.eatright.userInfo.helperClass;
//
//import com.sred.eatright.userInfo.Profile;
//import com.sred.eatright.userInfo.helperClass.FitnessGoal;
//import com.sred.eatright.userInfo.helperClass.Gender;
//
//public class NutritionGoal {
//    //private Nutrient goalNutrient;
//    private Profile profile;
//    private double BMR;
//    private int goalCalories;
//
//    public NutritionGoal(Profile profile) {
//        this.profile = profile;
//        setBMR();
//        setGoalCaloriesActivityLevel();
//        setGoalCaloriesFitnessGoal();
//    }
//
//    //call this function when users change their needs or biometrics
//    public void updateGoalCalories() {
//        setBMR();
//        setGoalCaloriesActivityLevel();
//        setGoalCaloriesFitnessGoal();
//    }
//
//    //calculate the BMR
//    public void setBMR() {
//        double BMR = 0;
//        Gender gender = profile.getGender();
//        if(gender == Gender.MALE || gender == Gender.PREFERNOTTOSAY)
//        {
//            BMR = 66 + (6.3 * profile.getGoal().getCurWeight()) + (12.9 * profile.getHeight()) - (6.8 * profile.getAge());
//        }
//        if (gender == Gender.FEMALE)
//        {
//            BMR = 655 + (4.3 * profile.getGoal().getCurWeight()) + (4.7 * profile.getHeight()) - (4.7 * profile.getAge());
//        }
//        this.BMR = BMR;
//    }
//
//    public void setGoalCaloriesActivityLevel() {
//        double goalCalories;
////        ActivityLevelActivity activityLevel = profile.getGoal().getActivityLevel();
//
//        /**
//         *
//         */
//        String activityLevel = "String from DB";
//
//
//        if(activityLevel == "SEDENTARY") {
//            goalCalories = BMR * 1.2;
//        }
//        else if(activityLevel == "SLIGHTLYACTIVE") {
//            goalCalories = BMR * 1.375;
//        }
//        else if(activityLevel == "MODERATELYACIVE") {
//            goalCalories = BMR * 1.55;
//        }
//        else if(activityLevel == "VERYACTIVE") {
//            goalCalories = BMR * 1.725;
//        }
//        else {
//            goalCalories = BMR * 1.9;
//        }
//        this.goalCalories = (int)goalCalories;
//    }
//
//
//    public void setGoalCaloriesFitnessGoal() {
//        FitnessGoal fitnessGoal = profile.getGoal().getFitnessGoal();
//        if(fitnessGoal == FitnessGoal.GAIN) {
//            goalCalories = goalCalories + 500;
//        }
//        else if(fitnessGoal == FitnessGoal.LOSE) {
//            goalCalories = goalCalories - 500;
//        }
//    }
//
//    //setter
//    public void updateGoalCalories(int goalCalories)
//    {
//        this.goalCalories = goalCalories;
//    }
//    //getter
//
//    public int getGoalCalories() {
//        return goalCalories;
//    }
//}
