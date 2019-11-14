package com.sred.eatright;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FoodDiary {
    private Date myDate;
    private Nutrient overAllNutrients;
    private int overAllCalories;
    private List<Meals> mealsList;
    private Calculator calculator;

    FoodDiary(Date date) {
        this.myDate = date;
        this.mealsList = new ArrayList<>();
        this.calculator = new Calculator(NutritionGoal nutritionGoal);
        addMeals();
        calculateOverAllNutrients();
        calculateOverAllNutrients();
    }

    private void addMeals() {
        mealsList.add(new Breakfast());
        mealsList.add(new Lunch());
        mealsList.add(new Dinner());
    }

    //getter
//    public List<Meals> getMealsList() {
//        return mealsList;
//    }
    public Nutrient getOverAllNutrients() {
        return overAllNutrients;
    }
    public int getOverAllCalories() {
        return overAllCalories;
    }

    public void calculateOverAllNutrients() {
        double overAllProtein = 0;
        double overAllCarbohydrates = 0;
        double overAllFat = 0;
        if (mealsList != null || !mealsList.isEmpty()){
            for(int i = 0; i < mealsList.size(); i++) {
                //get each food's nutrient value
                overAllProtein = overAllProtein + mealsList.get(i).getOverAllNutrients().getProtein();
                overAllCarbohydrates = overAllCarbohydrates + mealsList.get(i).getOverAllNutrients().getCarbohydrates();
                overAllFat = overAllFat + overAllCarbohydrates + mealsList.get(i).getOverAllNutrients().getFat();
            }
        }
        this.overAllNutrients = new Nutrient.NutrientBuilder().setProtein(overAllProtein)
                                                            .setCarbohydrates(overAllCarbohydrates)
                                                            .setFat(overAllFat)
                                                            .buildNutrient();
    }
    public int calculateOverAllCalories() {
        return  this.overAllCalories = mealsList.get(1).getOverAllCalories() + mealsList.get(2).getOverAllCalories() + mealsList.get(3).getOverAllCalories();
    }


    //Do not need to create remove Meals, because we only add Breakfast, lunch and dinner for the time being. May need to implement this function in the future
    //When implement this function, you need to ovverride equals and hashchode in "Meals"
//    public void removeMeals() {
//
//    }
}
