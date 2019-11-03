package com.sred.eatright;

public class Food {
    private Macros macros;
    private int calories;
    private String servingSize;
    private double numOfServings;

    public void setMacros(Macros macros) {
        this.macros = macros;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public void setNumOfServings(double numOfServings) {
        this.numOfServings = numOfServings;
    }
    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public Macros getMacros() {
        return macros;
    }
    public int getCalories() {
        return calories;
    }
    public double getNumOfServings() {
        return numOfServings;
    }
    public String getServingSize() {
        return servingSize;
    }
}
