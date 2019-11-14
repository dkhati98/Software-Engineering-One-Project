package com.sred.eatright;

public class NutritionGoal {
    private Nutrient nutrient;


/// start of calorie goal calculator

    private Profile profile;
    FitnessGoal goal;
    private double BMR;
    private int CaloriecNeed;
    private int CalorieToMaintain;

    //to get Nutrient



    public NutritionGoal(FitnessGoal goal, Profile profile)
    {
        this.goal = goal;
        this.profile = profile;
        BMR = BMRCalculator();
        CalorieToMaintain = (int) getCalorieToMaintain(BMR);
    }





    public void setCaloriecNeed(int manualCalories)
    {
        this.CaloriecNeed = manualCalories;
    }

    public int getGoalCalories() {

        if(profile.setGoal().getFitnessGoal()==FitnessGoal.MAINTAIN)
        {
            CaloriecNeed = CalorieToMaintain;
        }
        else if(profile.setGoal().getFitnessGoal()==FitnessGoal.LOSE)
        {
            CaloriecNeed = CalorieToMaintain -500;

        }
        else
        {
            CaloriecNeed =CalorieToMaintain + 500;
        }

        return CaloriecNeed;
    }

    private double BMRCalculator()
    {

        if(profile.getGender()==Gender.MALE)
        {
            BMR= 66 + (6.3*profile.setGoal().getCurWeight()) + (12.9*profile.getHeight()) - (6.8*profile.getAge());
        }
        if (profile.getGender()==Gender.FEMALE)
        {
            BMR = 655 + (4.3*profile.setGoal().getCurWeight()) + (4.7*profile.getHeight()) - (4.7*profile.getAge());
        }
        return BMR;
    }
    private double getCalorieToMaintain(double bmr)
    {
        double calorie =0 ;
        if(profile.setGoal().getActivityLevel()==ActivityLevel.SEDENTARY)
        {
            calorie = bmr * 1.2;
        }
        else if(profile.setGoal().getActivityLevel()==ActivityLevel.SLIGHTLYACTIVE)
        {
            calorie = bmr * 1.375;
        }
        else if(profile.setGoal().getActivityLevel()==ActivityLevel.MODERATELYACIVE)
        {
            calorie = bmr * 1.55;
        }
        else if(profile.setGoal().getActivityLevel()==ActivityLevel.VERYACTIVE)
        {
            calorie = bmr * 1.725;
        }
        else
        {
            calorie = bmr * 1.9;
        }

        return calorie;
    }



    ////end of calorie goal calculator


}
