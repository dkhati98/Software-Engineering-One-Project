package com.sred.eatright;

public class Calculator {
    private NutritionGoal nutritionGoal;
    private int goal;
    private int remaining;
    private int foodCalorie;

    public Calculator(NutritionGoal nutritionGoal ){
        this.nutritionGoal =nutritionGoal;
        remaining = getGoal();



    }

    private int getfoodCalorie(int foodCalorie)
    {
        return foodCalorie;
    }

    private int getGoal()
    {
        goal = nutritionGoal.getGoalCalories();
        return goal;
    }

    public int getRemaining(int foodCalorie)
    {
        remaining-=foodCalorie;
        return remaining;
    }

    public Calculator() {

    }
}
