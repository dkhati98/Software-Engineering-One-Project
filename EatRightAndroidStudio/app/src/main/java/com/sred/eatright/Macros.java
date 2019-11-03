package com.sred.eatright;

public class Macros {
    private double protein;
    private double carbonHydrates;
    private double fat;

    private Macros(MacrosBuilder builder) {
        this.protein = builder.protein;
        this.carbonHydrates = builder.carbonHydrates;
        this.fat = builder.fat;
    }

    public double getProtein() {
        return protein;
    }
    public double getCarbonHydrates() {
        return carbonHydrates;
    }
    public double getFat() {
        return fat;
    }

    public static class MacrosBuilder {
        private double protein;
        private double carbonHydrates;
        private double fat;

        public MacrosBuilder setProtein(double protein) {
            this.protein = protein;
            return this;
        }
        public MacrosBuilder setCarbonHydrates(double carbonHydrates) {
            this.carbonHydrates = carbonHydrates;
            return this;
        }
        public MacrosBuilder setFat(double fat) {
            this.fat = fat;
            return this;
        }
        public Macros build() {
            return new Macros(this);
        }
    }
}
