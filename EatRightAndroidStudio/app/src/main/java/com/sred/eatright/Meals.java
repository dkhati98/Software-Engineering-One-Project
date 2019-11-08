package com.sred.eatright;

import java.util.ArrayList;
import java.util.List;

public class Meals implements FoodAdding{
    private Nutrient overAllNutrient;
    private int overAllCalories;
    private List<OurFood> ourFoodList = new ArrayList<>();
    private OurFood ourFood;

    private void setOverAllNutrient(Nutrient overAllNutrient) {


        this.overAllNutrient = overAllNutrient;
    }
    private void setOverAllCalories(int overAllCalories) {


        this.overAllCalories = overAllCalories;
    }
    public void createFood(DB db_Food) {
        OurFood ourFood = new OurFood(db_Food);


        this.ourFood = ourFood;
    }
    public Nutrient getOverAllNutrient() {
        return overAllNutrient;
    }
    public int getOverAllCalories() {
        return overAllCalories;
    }
    public OurFood getOurFood() {
        return ourFood;
    }

    public List<OurFood> getOurFoodList() {
        return ourFoodList;
    }
    public void removeFood(OurFood ourFood) {
        this.ourFoodList.remove( );//need to find which one needs to be removed
        setOverAllCalories();
        setOverAllNutrient();
    }
    @Override
    public void addingFood(OurFood ourFood) {
        this.ourFoodList.add(ourFood);
        setOverAllCalories();
        setOverAllNutrient();
    }
    @Override
    public void scanningFood(OurFood food) {
        this.ourFoodList.add(food);
        setOverAllCalories();
        setOverAllNutrient();
    }
}
