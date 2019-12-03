package com.sred.eatright;

public class FoodForSearchBar {
    String FoodName;
    String Brandname;
    Double Calories;

    public FoodForSearchBar()
    {

    }
    public FoodForSearchBar(String foodName, String brandname, Double calories) {
        FoodName = foodName;
        Brandname = brandname;
        Calories = calories;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getBrandname() {
        return Brandname;
    }

    public void setBrandname(String brandname) {
        Brandname = brandname;
    }

    public Double getCalories() {
        return Calories;
    }

    public void setCalories(Double calories) {
        Calories = calories;
    }
}
