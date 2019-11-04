package com.sred.eatright;

public class Nutrient {
    //unit in grams
    private double protein;
    private double carbonHydrates;
    private double fat;

    private Nutrient(NutrientBuilder builder) {
        this.protein = builder.protein;
        this.carbonHydrates = builder.carbonHydrates;
        this.fat = builder.fat;
    }

    //setter
    public void setProtein(double protein) {
        this.protein = protein;
    }
    public void setCarbonHydrates(double carbonHydrates) {
        this.carbonHydrates = carbonHydrates;
    }
    public void setFat(double fat) {
        this.fat = fat;
    }

    //getter
    public double getProtein() {
        return protein;
    }
    public double getCarbonHydrates() {
        return carbonHydrates;
    }
    public double getFat() {
        return fat;
    }

    //builder
    public static class NutrientBuilder {
        private double protein;
        private double carbonHydrates;
        private double fat;

        public NutrientBuilder setProtein(double protein) {
            this.protein = protein;
            return this;
        }
        public NutrientBuilder setCarbonHydrates(double carbonHydrates) {
            this.carbonHydrates = carbonHydrates;
            return this;
        }
        public NutrientBuilder setFat(double fat) {
            this.fat = fat;
            return this;
        }
        public Nutrient build() {
            return new Nutrient(this);
        }
    }
}
