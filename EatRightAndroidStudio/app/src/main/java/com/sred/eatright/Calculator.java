package com.sred.eatright;

public class Calculator {
    private int goal;
    private int remaining;
    private int foodCalories;

    public Calculator(Profile profile, int overAllCalories){
        goal = profile.getGoal().getNutrionGoal().getGoalCalories();
        setFoodCalories(overAllCalories);
        setRemaining();
    }

    public void setFoodCalories(int overAllCalories) {
        foodCalories = overAllCalories;
    }

    public void setRemaining() {
        remaining = goal -  foodCalories;
    }

    public int getRemaining() {
        return remaining;
    }
}
