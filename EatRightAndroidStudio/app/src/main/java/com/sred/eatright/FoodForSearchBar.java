package com.sred.eatright;

public class FoodForSearchBar {
    String FoodName;
    String Brandname;
    Double Calories;
    Double Protein;
    Double Carbs;
    Double Fats;

    public Double getProtein() {
        return Protein;
    }

    public void setProtein(Double protein) {
        Protein = protein;
    }

    public Double getCarbs() {
        return Carbs;
    }

    public void setCarbs(Double carbs) {
        Carbs = carbs;
    }

    public Double getFats() {
        return Fats;
    }

    public void setFats(Double fats) {
        Fats = fats;
    }

    public FoodForSearchBar()
    {

    }
    public FoodForSearchBar(String foodName, String brandname, Double calories, Double protein,Double carbs, Double fats) {
        Protein= protein;
        Carbs= carbs;
        Fats=fats;
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
