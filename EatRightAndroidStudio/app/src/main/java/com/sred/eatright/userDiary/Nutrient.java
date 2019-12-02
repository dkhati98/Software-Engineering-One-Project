//package com.sred.eatright.userDiary;
//
//public class Nutrient {
//    //unit in grams
//    private double protein;
//    private double carbohydrates;
//    private double fat;
//
//    public Nutrient(NutrientBuilder builder) {
//        this.protein = builder.protein;
//        this.carbohydrates = builder.carbohydrates;
//        this.fat = builder.fat;
//    }
//
//    //setter
//    protected void setProtein(double protein) {
//        this.protein = protein;
//    }
//    protected void setCarbohydrates(double carbohydrates) {
//        this.carbohydrates = carbohydrates;
//    }
//    protected void setFat(double fat) {
//        this.fat = fat;
//    }
//
//    //getter
//    public double getProtein() {
//        return protein;
//    }
//    public double getCarbohydrates() {
//        return carbohydrates;
//    }
//    public double getFat() {
//        return fat;
//    }
//
//    //builder using builder pattern here, because we may introduce more fields in the future
//
//    public static class NutrientBuilder {
//        private double protein;
//        private double carbohydrates;
//        private double fat;
//
//        public NutrientBuilder setProtein(double protein) {
//            this.protein = protein;
//            return this;
//        }
//        public NutrientBuilder setCarbohydrates(double carbohydrates) {
//            this.carbohydrates = carbohydrates;
//            return this;
//        }
//        public NutrientBuilder setFat(double fat) {
//            this.fat = fat;
//            return this;
//        }
//        public Nutrient buildNutrient() {
//            return new Nutrient(this);
//        }
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof OurFood)) {
//            return false;
//        }
//        Nutrient nutrient = (Nutrient) obj;
//        return this.getProtein() == nutrient.getProtein() &&
//                this.getCarbohydrates() == nutrient.getCarbohydrates() &&
//                this.getFat() == nutrient.getFat();
//    }
//
//    @Override
//    public int hashCode() {
//        return (int)Double.doubleToLongBits(protein) * 31 * 31 + (int)Double.doubleToLongBits(carbohydrates) * 31 + (int)Double.doubleToLongBits(fat);
//    }
//}
